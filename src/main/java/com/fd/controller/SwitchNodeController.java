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
public class SwitchNodeController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(SwitchNodeController.class);
	
	@RequestMapping(method= RequestMethod.GET, path = "/redfish/v1/rich/SwitchNodes", produces="application/json")
    public @ResponseBody
    String list(@RequestParam(value="$skip", required=false, defaultValue="0") int start,
                @RequestParam(value="$top", required=false, defaultValue="1") int size,
                @RequestHeader(value="Authorization", required=true) String basicAuthString) {

        logger.info("call /redfish/v1/rich/SwitchNodes $skip = {}, $top = {}", start, size);
        logger.info("Basic auto string {}", basicAuthString);

        return readJson("switch-nodes/switch-node-list.json");
    }
	
	@RequestMapping(method= RequestMethod.GET, path = "/redfish/v1/rich/SwitchNodes/{nodeId}", produces="application/json")
    public @ResponseBody
    String getDetail(@PathVariable(value="nodeId", required=false) String nodeid,
                @RequestHeader(value="Authorization", required=true) String basicAuthString) {
		
		logger.info("call /redfish/v1/rich/SwitchNodes/{nodeId} with with param {}", nodeid);
        logger.info("Basic auto string {}", basicAuthString);

		return readJson("switch-nodes/switch-node-"+nodeid+".json");
	}
		
}
