package com.esight.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * Created by harbor on 6/21/2017.
 */
@RestController
public class LoginControler {

    private static final Logger logger = LoggerFactory.getLogger(LoginControler.class);

    private String hashMD5 (String source){

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(source.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();

    }

    private Set<String> openidSet = new HashSet<>();

    @RequestMapping(method= RequestMethod.PUT,path = "/rest/openapi/sm/session")
    public @ResponseBody
    ESightResponseObject login(@RequestParam(value="userid", required=false, defaultValue="openApiUser") String userid,
                                  @RequestParam(value="value", required=false, defaultValue="Simple.0") String value) {
        ESightResponseObject responseObject = new ESightResponseObject();

        logger.info("user/password is {}/{}",userid,value);

        if("openApiUser".equals(userid)&&"Simple.0".equals(value)){
//        if(2>1){

            String openid = UUID.randomUUID().toString();

            String md5Openid =  hashMD5(openid);

            openidSet.add(md5Openid);

            responseObject.setData(md5Openid);

            responseObject.setDescription("login successfully.");
            responseObject.setCode(0);

            logger.info("login successfully, openid = {}.", md5Openid);

        }else{
            responseObject.setData("");
            responseObject.setDescription("login failed.");
            responseObject.setCode(-1);
            logger.info("login failed.");
        }



        return responseObject;
    }

    @RequestMapping(method= RequestMethod.DELETE, path = "/rest/openapi/sm/session")
    public @ResponseBody ESightResponseObject
    logout(@RequestHeader(value="openid", required=true) String openid,
           @RequestParam(value="openid",  required=true) String id){

        ESightResponseObject responseObject = new ESightResponseObject();
        responseObject.setData(null);

        if (openidSet.contains(openid) && openidSet.contains(id)) {
            openidSet.remove(openid);
            responseObject.setCode(0);
            responseObject.setDescription("Operation success.");

            logger.info("openid {} destroyed", openid);

        } else {
            responseObject.setCode(1);
            responseObject.setDescription("openID is wrong.");
        }

        return responseObject;
    }

}

class ESightResponseObject {

    private int code;

    private String data;

    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


