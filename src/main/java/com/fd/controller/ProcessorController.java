package com.fd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessorController extends BaseController {
    
    private static final Logger logger = LoggerFactory.getLogger(NodeController.class);

    @RequestMapping(method= RequestMethod.GET, path = "/redfish/v1/rich/Nodes/{nodeId}/Processor", produces="application/json")
    public @ResponseBody
    String list(@PathVariable(value="nodeId", required=true) String nodeId ,
                @RequestHeader(value="Authorization", required=true) String basicAuthString) {

        logger.info("call /redfish/v1/rich/Nodes/{nodeId}/Processor with param {}", nodeId);
//        logger.info("Basic auto string {}", basicAuthString);

        return readJson("nodes/node-"+nodeId+"-processor.json", false);
    }
}
