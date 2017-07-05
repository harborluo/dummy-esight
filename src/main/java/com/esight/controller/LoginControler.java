package com.esight.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by harbor on 6/21/2017.
 */
@RestController
public class LoginControler {

    @RequestMapping(method= RequestMethod.PUT,path = "/rest/openapi/sm/session")
    public @ResponseBody
    ESightResponseObject login(@RequestHeader(value="userid", required=false, defaultValue="userid") String userid,
                                  @RequestHeader(value="value", required=false, defaultValue="value") String value) {
        ESightResponseObject responseObject = new ESightResponseObject();
        if("openApiUser".equals(userid)&&"Simple.0".equals(value)){
            responseObject.setData("b81d9a20d4eef879aabe034fc9860350fa7ad85b01234ed9");
            responseObject.setDescription("login successfully.");
            responseObject.setCode(0);
        }else{
            responseObject.setData("");
            responseObject.setDescription("login failed.");
            responseObject.setCode(-1);
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


