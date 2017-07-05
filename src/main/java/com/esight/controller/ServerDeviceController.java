package com.esight.controller;

import com.esight.controller.bean.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by harbor on 6/21/2017.
 */
@RestController
public class ServerDeviceController {

    @RequestMapping(method= RequestMethod.GET,path = "/rest/openapi/server/device")
    public @ResponseBody
    ResponseServerDeviceListBean list(@RequestParam(value="servertype", required=false, defaultValue="servertype") String servertype,
                                      @RequestParam(value="start", required=false, defaultValue="1") int start,
                                      @RequestParam(value="size", required=false, defaultValue="100") int size,
                                      @RequestHeader(value="openid", defaultValue="openid") String openid) {
        ResponseServerDeviceListBean response = new ResponseServerDeviceListBean();
        response.setSize(size);
        response.setCode(0);
        response.setDescription("Succeeded in querying the server list.");
        response.setTotalPage(1);

        List<ServerDeviceBean> dataList = new ArrayList<>();

        if("rack".equals(servertype)){

            for(int i=1;i<=5;i++){

                ServerDeviceBean serverDevice = new ServerDeviceBean();
                serverDevice.setDn("NE=3460300"+i);
                serverDevice.setIpAddress("192.168.10.8"+i);
                serverDevice.setServerName("RH2288H V3-192.168.10.8"+i);
                serverDevice.setServerModel("RH2288H V3");
                serverDevice.setManufacturer("Huawei Technologies Co., Ltd.");
                serverDevice.setProductSN("2CA1CA0A1DD21"+i);
                serverDevice.setUuid("2CA1CA0A-1DD2-11B2-9D5B-0018E1C5D86"+i);

                if(i==1){
                    List<ChildBladeBean> childBlades = new ArrayList<ChildBladeBean>();
                    ChildBladeBean childBladeBean = new ChildBladeBean();

                    childBladeBean.setIpAddress("192.168.10.82");
                    childBladeBean.setDn("NE=34603002");
                    childBlades.add(childBladeBean);

                    ChildBladeBean childBladeBean2 = new ChildBladeBean();
                    childBladeBean2.setIpAddress("192.168.10.83");
                    childBladeBean2.setDn("NE=34603003");
                    childBlades.add(childBladeBean2);

                    serverDevice.setChildBlades(childBlades);
                }

                dataList.add(serverDevice);
            }

        }


        response.setData(dataList);

        return response;
    }

    @RequestMapping(method= RequestMethod.GET,path = "/rest/openapi/server/device/detail")
    public @ResponseBody
    ResponseServerDeviceDetailBean detail(@RequestParam(value="dn", required=false, defaultValue="dn") String dn,
                                          @RequestHeader(value="openid", defaultValue="openid") String openid) {
        ResponseServerDeviceDetailBean response = new ResponseServerDeviceDetailBean();
        ServerDeviceDetailBean serverDevice = new ServerDeviceDetailBean();

        int i = Integer.parseInt(dn.substring(dn.length()-1,dn.length()));

        serverDevice.setDn(dn);
        serverDevice.setIpAddress("192.168.10.8"+i);
        serverDevice.setName("RH2288H V3-192.168.10.8"+i);
        serverDevice.setType("RH2288H V3");
        serverDevice.setUuid("2CA1CA0A-1DD2-11B2-9D5B-0018E1C5D86"+i);
        serverDevice.setStatus(getRandomSate());
        serverDevice.setCpuCores(2);
        serverDevice.setCpuNums(2);
        serverDevice.setMemoryCapacity("32768MB");

        //memory
        List<MemoryBean> memoryBeanList = new ArrayList<>();
        for(int idx=1;idx<=4;idx++){
            MemoryBean memoryBean = new MemoryBean();
            memoryBean.setCapacity("8192 MB");
            memoryBean.setFrequency("2133 MHz");
            memoryBean.setHealthState(getRandomSate());
            memoryBean.setManufacture("Samsung");
            memoryBean.setName("Memory-"+idx);

            memoryBeanList.add(memoryBean);
        }
        serverDevice.setMemory(memoryBeanList);

        //board
        List<BoardBean> boardBeanList = new ArrayList<>();
        for(int idx=1;idx<=2;idx++){
            BoardBean boardBean = new BoardBean();
            boardBean.setName("BC11HGSA"+idx);
            boardBean.setHealthState(getRandomSate());
            boardBean.setManufacture("Huawei");
            boardBean.setSn("022HLVCNGC011388");
            boardBean.setManuTime("2016-12-30 13:57:00");
            boardBean.setType("0");

            boardBeanList.add(boardBean);
        }
        serverDevice.setBoard(boardBeanList);

        //cpu
        List<CPUBean> cpuBeanList = new ArrayList<>();
        for(int idx=1;idx<=3;idx++){
            CPUBean cpuBean = new CPUBean();
            cpuBean.setName("CPU"+i+idx);
            cpuBean.setManufacture("Intel(R) Corporation");
            cpuBean.setFrequency("3400 MHz");
            cpuBean.setHealthState(getRandomSate());
            cpuBean.setModel("Genuine Intel(R) CPU @ 3.40GHz");
            cpuBeanList.add(cpuBean);
        }
        serverDevice.setCPU(cpuBeanList);

        //disk
        List<DiskBean> diskBeanList = new ArrayList<>();
        for(int idx=1;idx<=3;idx++){
            DiskBean diskBean = new DiskBean();
            diskBean.setName("HardDisk-"+i+idx);
            diskBean.setHealthState(getRandomSate());
            diskBean.setLocation(""+i+idx);
            diskBeanList.add(diskBean);
        }
        serverDevice.setDisk(diskBeanList);

        //psu
        List<PSUBean> psuBeanList = new ArrayList<>();
        for(int idx=1;idx<=2;idx++){
            PSUBean psuBean = new PSUBean();
            psuBean.setHealthState(getRandomSate());
            psuBean.setInputMode(1);
            psuBean.setInputPower("138.0 W");
            psuBean.setName("PS"+i+idx);
            psuBean.setManufacture("HUAWE");
            psuBean.setVersion("DC: 107  PFC: 107");
            psuBeanList.add(psuBean);
        }
        serverDevice.setPSU(psuBeanList);

        //fan
        List<FanBean> fanBeanList = new ArrayList<>();
        for(int idx=1;idx<=4;idx++){
            FanBean fanBean = new FanBean();
            fanBean.setName("Fan_"+i+idx);
            fanBean.setHealthState(getRandomSate());
            fanBean.setControlModel("0");
            fanBean.setRotate("3720");
            fanBean.setRotatePercent("255");

            fanBeanList.add(fanBean);
        }
        serverDevice.setFan(fanBeanList);

        List<ServerDeviceDetailBean> dataList = new ArrayList<>();
        dataList.add(serverDevice);
        response.setData(dataList);
        response.setSize(1);
        response.setTotalPage(1);
        return response;
    }

    private int getRandomSate(){
        int states[] = {0,-1,-2};
        return states[new  Random().nextInt(3)];
    }

}
