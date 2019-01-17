package com.fd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esight.controller.ServerDeviceController;

@RestController
public class GroupController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	
	@RequestMapping(method= RequestMethod.GET, path = "/redfish/v1/rich/NodeGroups", produces="application/json")
    public @ResponseBody
    String list(@RequestParam(value="Type", required=false, defaultValue="") String type,
                @RequestHeader(value="Authorization", required=true) String basicAuthString) {

        logger.info("call /redfish/v1/rich/NodeGroups with param {}", type);
        logger.info("Basic auto string {}", basicAuthString);

        return readJson("group/group_list.json");
    }
	
	@RequestMapping(method= RequestMethod.GET, path = "/redfish/v1/rich/NodeGroups/{groupId}", produces="application/json")
    public @ResponseBody
    String getDetail(@PathVariable(value="groupId", required=false) String groupId,
                @RequestHeader(value="Authorization", required=true) String basicAuthString) {
		
		logger.info("call /redfish/v1/rich/NodeGroups/{groupId} with param {} ", groupId);
//        logger.info("Basic auto string {}", basicAuthString);

		return readJson("group/group-"+groupId+".json");
	}
		
}
