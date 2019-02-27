package com.fd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FusionDirectorController extends BaseController {
    
    @RequestMapping(method= RequestMethod.GET, path = "/redfish/v1/rich/Appliance/Version", produces="application/json")
    public @ResponseBody
    String getVersion(){
        return super.readJson("fd-version.json", false);
    }

}
