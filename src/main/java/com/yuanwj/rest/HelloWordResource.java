package com.yuanwj.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bmk on 17-8-16.
 */
@RestController
@RequestMapping(value = "/api/v1/yuanwj/")
public class HelloWordResource {

    @RequestMapping(value = "helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

}
