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

@RestController
public class DriveController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(DriveController.class);
	
	@RequestMapping(method= RequestMethod.GET, path = "/redfish/v1/rich/Nodes/{nodeId}/Storage/Drive", produces="application/json")
    public @ResponseBody
    String list(@RequestParam(value="$skip", required=false, defaultValue="0") int start,
                @RequestParam(value="$top", required=false, defaultValue="1") int size,
                @PathVariable(value="nodeId", required=true) String nodeId,
                @RequestHeader(value="Authorization", required=true) String basicAuthString) {

        logger.info("call /redfish/v1/rich/Nodes/{nodeId}/Storage/Drive with $skip = {}, $top = {}, nodeId = {}", start, size, nodeId);
//        logger.info("Basic auto string {}", basicAuthString);

        return readJson("nodes/node-"+nodeId+"-drive.json");
    }
	
	
	@RequestMapping(method= RequestMethod.GET, path = "/redfish/v1/rich/Nodes/{nodeId}/Storage/Drive/{driveId}", produces="application/json")
    public @ResponseBody
    String getNodeDetail(@PathVariable(value="nodeId", required=false) String nodeid,
    		@PathVariable(value="driveId", required=false) String driveId,
                @RequestHeader(value="Authorization", required=true) String basicAuthString) {
		
		logger.info("call /redfish/v1/rich/Nodes/{nodeId}/Storage/Drive/{driveId} with param {} {}", nodeid, driveId);
//        logger.info("Basic auto string {}", basicAuthString);

		return readJson("nodes/drive-"+driveId+".json");
	}
	
}
