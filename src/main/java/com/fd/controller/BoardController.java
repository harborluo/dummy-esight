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
public class BoardController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(method= RequestMethod.GET, path = "/redfish/v1/rich/SwitchNodes/{nodeId}/Board", produces="application/json")
    public @ResponseBody
    String list(
//    		@RequestParam(value="$skip", required=false, defaultValue="0") int start,
//                @RequestParam(value="$top", required=false, defaultValue="1") int size,
    		@PathVariable(value="nodeId",required=true) String nodeId,
                @RequestHeader(value="Authorization", required=true) String basicAuthString) {

        logger.info("call /redfish/v1/rich/SwitchNodes/{nodeId}/Board with param {}", nodeId);
//        logger.info("Basic auto string {}", basicAuthString);

        return readJson("switch-nodes/switch-node-"+nodeId+"-board.json");
    }
	
	@RequestMapping(method= RequestMethod.GET, path = "/redfish/v1/rich/SwitchNodes/{nodeId}/Board/{boardId}", produces="application/json")
    public @ResponseBody
    String getDetail(@PathVariable(value="nodeId", required=false) String nodeid,
    		@PathVariable(value="boardId", required=false) String boardId,
                @RequestHeader(value="Authorization", required=true) String basicAuthString) {
		
		logger.info("call /redfish/v1/rich/SwitchNodes/{nodeId} with with param {} {}", nodeid, boardId);
//        logger.info("Basic auto string {}", basicAuthString);

		return readJson("switch-nodes/board-"+boardId+".json");
	}
		
}
