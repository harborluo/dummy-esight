package com.esight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by harbor on 6/21/2017.
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "hello!";
    }
}
