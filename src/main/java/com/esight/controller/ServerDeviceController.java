package com.esight.controller;

import com.esight.com.esight.json.DummyJson;
import com.esight.controller.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by harbor on 6/21/2017.
 */
@RestController
public class ServerDeviceController {

    private static final Logger logger = LoggerFactory.getLogger(ServerDeviceController.class);


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

        String devicePrefix;

        if("blade".equals(servertype)){
            devicePrefix = "NE=3460300";
        }
        else if("rack".equals(servertype)){
            devicePrefix = "NE=3470300";
        }
        else if("highdensity".equals(servertype)){
            devicePrefix = "NE=3480300";
        }
        else if("storagenode".equals(servertype)){
            devicePrefix = "NE=3490300";
        }
        else if("thirdpartyserver".equals(servertype)){
            devicePrefix = "NE=3500300";
        }
        else {
            return response;
        }

        logger.info("server type is {}, devicePrefix is {}", servertype, devicePrefix);

        for(int i=1;i<=9;i++){

            ServerDeviceBean serverDevice = new ServerDeviceBean();
            serverDevice.setDn(devicePrefix+i);
            serverDevice.setIpAddress("192.168.10.8"+i);
            serverDevice.setServerName("RH2288H V3-192.168.10.8"+i);
            serverDevice.setServerModel("RH2288H V3");
            serverDevice.setManufacturer("Huawei Technologies Co., Ltd.");
            serverDevice.setProductSN("2CA1CA0A1DD21"+i);
            serverDevice.setUuid("2CA1CA0A-1DD2-11B2-9D5B-0018E1C5D86"+i);

            if("blade".equals(servertype)){
                if(i==1){
                    List<ChildBladeBean> childBlades = new ArrayList<ChildBladeBean>();
                    ChildBladeBean childBladeBean = new ChildBladeBean();

                    childBladeBean.setIpAddress("192.168.10.82");
                    childBladeBean.setDn(devicePrefix+"2");
                    childBlades.add(childBladeBean);

                    ChildBladeBean childBladeBean2 = new ChildBladeBean();
                    childBladeBean2.setIpAddress("192.168.10.83");
                    childBladeBean2.setDn(devicePrefix+"3");
                    childBlades.add(childBladeBean2);

                    serverDevice.setChildBlades(childBlades);
                }
            }

            dataList.add(serverDevice);
        }

//        }

        response.setData(dataList);

        if("blade".equals(servertype)) {
            response.setData(DummyJson.getInstance().getData());
        }

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


        serverDevice.setIpAddress(DummyJson.getInstance().getIP(dn));

        if(serverDevice.getIpAddress()==null) {
            serverDevice.setIpAddress("192.168.10.8" + i);
        }

        serverDevice.setName("RH2288H V3-192.168.10.8"+i);
        serverDevice.setType("RH2288H V3");
        serverDevice.setUuid("2CA1CA0A-1DD2-11B2-9D5B-0018E1C5D86"+i);
        serverDevice.setStatus(getRandomSate());
        serverDevice.setCpuCores(2);
        serverDevice.setCpuNums(2);
        serverDevice.setMemoryCapacity("32768MB");

        serverDevice.setBmcMacAddr("f0:98:38:b1:e0:a0");
        serverDevice.setProductSn("2CA1CA0A1DD211");

        //memory
        List<MemoryBean> memoryBeanList = new ArrayList<>();
        for(int idx=1;idx<=4;idx++){
            MemoryBean memoryBean = new MemoryBean();
            memoryBean.setCapacity("8192 MB");
            memoryBean.setFrequency("2133 MHz");
            memoryBean.setHealthState(getRandomSate());
            memoryBean.setManufacture("Samsung");
            memoryBean.setName("Memory-"+idx);

            memoryBean.setMoId(i+""+idx);
            memoryBean.setPresentState(0);
            memoryBean.setUuid("RackServer2CA1CA0A1DD211motherboardRH2288H V3-192.168.10.82memory0"+idx);
            memoryBean.setPresentState(1);

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
            boardBean.setType(rand(new String[]{"0","1"}));
            boardBean.setPartNumber("J4300-2FEL-S-AC-TAA"+idx);

            boardBean.setUuid("RackServer2CA1CA0A1DD211motherboardRH2288H V3-192.168.10.82");
            boardBean.setMoId(""+idx);

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

            cpuBean.setUuid("RackServer2CA1CA0A1DD211motherboardRH2288H V3-192.168.10.82cpuCPU1mainboard");
            cpuBean.setPresentState(1);
            cpuBean.setMoId(idx+"");

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

            diskBean.setUuid("RackServer2CA1CA0A1DD211motherboardRH2288H V3-192.168.10.82diskHardDisk-1"+idx);
            diskBean.setMoId(""+idx);

            diskBeanList.add(diskBean);
        }
        serverDevice.setDisk(diskBeanList);

        //psu
        List<PSUBean> psuBeanList = new ArrayList<>();
        for(int idx=1;idx<=2;idx++){
            PSUBean psuBean = new PSUBean();
            psuBean.setHealthState(getRandomSate());
            psuBean.setInputMode(rand(new Integer[]{1,2,3}));
            psuBean.setInputPower("138.0 W");
            psuBean.setName("PS"+i+idx);
            psuBean.setManufacture("HUAWE");
            psuBean.setVersion("DC: 107  PFC: 107");

            psuBean.setUuid("RackServer2CA1CA0A1DD211powerPS1");
            psuBean.setPresentState(1);
            psuBean.setPowerProtocol(rand(new String[]{"0","1"}));
            psuBean.setRatePower("750.0 W");
            psuBean.setModel("HUAWE 750W PLATINUM PS");
            psuBean.setMoId(""+idx);

            psuBeanList.add(psuBean);
        }
        serverDevice.setPSU(psuBeanList);

        //fan
        List<FanBean> fanBeanList = new ArrayList<>();
        for(int idx=1;idx<=4;idx++){
            FanBean fanBean = new FanBean();
            fanBean.setName("Fan_"+i+idx);
            fanBean.setHealthState(getRandomSate());
            fanBean.setControlModel(rand(new String[]{"0","1"}));
            fanBean.setRotate("3720");
            fanBean.setRotatePercent(rand(new String[]{"10","20","30","255"}));

            fanBean.setMoId(""+idx);
            fanBean.setUuid("RackServer2CA1CA0A1DD211fanFan1 Front");
            fanBean.setPresentState(1);

            fanBeanList.add(fanBean);
        }
        serverDevice.setFan(fanBeanList);

        //RAID
        List<RAIDBean> RAIDList = new ArrayList<>();
        for(int idx=1;idx<=4;idx++){
            RAIDBean bean = new RAIDBean();
            bean.setName("RAID-"+idx);
            bean.setMoId(""+idx);
            bean.setHealthState(getRandomSate());
            bean.setRaidType("LSI SAS3108");
            bean.setInterfaceType(rand(new String[]{"1","2","3","4","5","5","255","unknown"}));
            bean.setBbuType("N/A");
            bean.setUuid("RackServer2CA1CA0A1DD211motherboardRH2288H V3-192.168.10.82raid"+idx);

            RAIDList.add(bean);
        }
        serverDevice.setRAID(RAIDList);

        //NetworkCard
        List<NetworkCardBean> NetworkCardList = new ArrayList<>();
        for(int idx=1;idx<=4;idx++){
            NetworkCardBean bean = new NetworkCardBean();
            bean.setNetWorkCardName("NIC"+idx);
            bean.setMacAdress("18-DE-D7-81-AF-CC");
            bean.setMoId(""+idx);
            bean.setUuid("RackServer2CA1CA0A1DD211motherboardRH2288H V3-192.168.10.82networkNIC"+idx);

            NetworkCardList.add(bean);
        }
        serverDevice.setNetworkCard(NetworkCardList);

        //PCIE
        List<PCIEBean> PCIEList = new ArrayList<>();
        for(int idx=1;idx<=4;idx++){
            PCIEBean bean = new PCIEBean();
            bean.setName("pcie"+idx);
            bean.setMoId(""+idx);
            bean.setUuid("RackServer2CA1CA0A1DD211motherboardRH2288H pcie"+idx);
            bean.setPciecardManufacturer("Huawei");
            bean.setPcieSsdCardHealthStatus(getRandomSate());
            bean.setPcieSsdCardLifeLeft("2 Month");

            PCIEList.add(bean);
        }
        serverDevice.setPCIE(PCIEList);


        List<ServerDeviceDetailBean> dataList = new ArrayList<>();
        dataList.add(serverDevice);
        response.setData(dataList);
        response.setSize(1);
        response.setTotalPage(1);

        logger.info("Device name is {}", dn);

        return response;
    }

    private int getRandomSate(){
        return rand(new Integer[]{0,-1,-2});
    }

    private <T> T rand(final T[] array){
        return array[new  Random().nextInt(array.length)];
    }



}
