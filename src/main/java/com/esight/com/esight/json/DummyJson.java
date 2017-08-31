package com.esight.com.esight.json;

import com.esight.controller.bean.ChildBladeBean;
import com.esight.controller.bean.ServerDeviceBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by harbor on 8/30/2017.
 */
public class DummyJson {

    private static final DummyJson instance = new DummyJson();

    List<ServerDeviceBean> data = new ArrayList<ServerDeviceBean>();

    private Map<String,String> dn2IPMap = new HashMap<>() ;

    private DummyJson() {
        initData();
    }

    private void addMap(String dn, String IP){
        dn2IPMap.put(dn,IP);
    }

    public String getIP(String dn){
        return dn2IPMap.get(dn);
    }

    private void initData() {
        ServerDeviceBean bean1 = new ServerDeviceBean();
        bean1.setIpAddress("172.100.110.1");
        bean1.setDn("NE=34603334");
        bean1.setServerName("E9000-172.100.110.1");
        bean1.setServerModel("E9000");
        bean1.setManufacturer("Huawei Technologies Co., Ltd.");
        bean1.setStatus("-3");
        bean1.setProductSN("210230102810H1000363");
        bean1.setLocation("shenzhen_E3");
        bean1.setVersion("6.01");

        addMap(bean1.getDn(),bean1.getIpAddress());

        List<ChildBladeBean> childBladeBeans = new ArrayList<>();
        childBladeBeans.add(new ChildBladeBean("NE=34603342","172.100.112.14"));
        childBladeBeans.add(new ChildBladeBean("NE=34603340","172.100.112.13"));
        childBladeBeans.add(new ChildBladeBean("NE=34603336","172.100.112.11"));
        childBladeBeans.add(new ChildBladeBean("NE=34603344","172.100.112.9"));
        childBladeBeans.add(new ChildBladeBean("NE=34603338","172.100.112.12"));

        addMap("NE=34603342","172.100.112.14");
        addMap("NE=34603340","172.100.112.13");
        addMap("NE=34603336","172.100.112.11");
        addMap("NE=34603344","172.100.112.9");
        addMap("NE=34603338","172.100.112.12");

        bean1.setChildBlades(childBladeBeans);

        data.add(bean1);

        ////////////////////////////////////////////////////////////////////////

        ServerDeviceBean bean2 = new ServerDeviceBean();
        bean2.setIpAddress("172.100.100.1");
        bean2.setDn("NE=34603317");
        bean2.setServerName("E9000-172.100.100.1");
        bean2.setServerModel("E9000");
        bean2.setManufacturer("Huawei Technologies Co., Ltd.");
        bean2.setStatus("-3");
        bean2.setProductSN("2102300742N0E3000156");
        bean2.setLocation("A03");
        bean2.setVersion("6.01");

        addMap(bean1.getDn(),bean1.getIpAddress());

        List<ChildBladeBean> childBladeBeans2 = new ArrayList<>();
        childBladeBeans2.add(new ChildBladeBean("NE=34603353","172.100.102.16"));
        childBladeBeans2.add(new ChildBladeBean("NE=34603351","172.100.102.15"));
        childBladeBeans2.add(new ChildBladeBean("NE=34603325","172.100.102.6"));
        childBladeBeans2.add(new ChildBladeBean("NE=34603323","172.100.102.4"));

        addMap("NE=34603353","172.100.102.16");
        addMap("NE=34603351","172.100.102.15");
        addMap("NE=34603325","172.100.102.6");
        addMap("NE=34603323","172.100.102.4");

        bean2.setChildBlades(childBladeBeans2);

        data.add(bean2);

    }

    public List<ServerDeviceBean> getData(){
        return data;
    }

    public static DummyJson getInstance() {
        return instance;
    }
}
