package com.esight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by harbor on 6/21/2017.
 */
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "hello!";
    }
}
