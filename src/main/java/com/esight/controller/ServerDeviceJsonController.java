package com.esight.controller;

import com.esight.controller.bean.ResponseServerDeviceDetailBean;
import com.esight.controller.bean.ResponseServerDeviceListBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by harbor on 9/5/2017.
 */
@RestController
public class ServerDeviceJsonController {

    @Autowired
    private ResourceLoader resourceLoader;

    private static final Logger logger = LoggerFactory.getLogger(ServerDeviceController.class);

    @RequestMapping(method= RequestMethod.GET, path = "/rest/openapi/server/device")
    public @ResponseBody
    String list(@RequestParam(value="servertype", required=false, defaultValue="servertype") String servertype,
                                      @RequestParam(value="start", required=false, defaultValue="1") int start,
                                      @RequestParam(value="size", required=false, defaultValue="100") int size,
                                      @RequestHeader(value="openid", defaultValue="openid") String openid) {

        logger.info("Querying server list of type {}",servertype);


        return readJson(servertype+".json");
    }

    @RequestMapping(method= RequestMethod.GET, path = "/rest/openapi/server/device/detail")
    public @ResponseBody
    String detail(@RequestParam(value="dn", required=false, defaultValue="dn") String dn,
                                          @RequestHeader(value="openid", defaultValue="openid") String openid) {

        logger.info("Querying server detail with dn= {}",dn);

        return readJson(dn+".json");
    }

private String readJson(String fileName){
        final StringBuilder out = new StringBuilder();
        try {
            InputStream inputStream  = resourceLoader.getResource("classpath:json/" + fileName).getInputStream();
            final int bufferSize = 1024;
            final char[] buffer = new char[bufferSize];

            Reader in = new InputStreamReader(inputStream, "UTF-8");
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
            return out.toString();


        }catch(IOException o){
            out.append("file not found!");
        }
    return out.toString();
}

}
