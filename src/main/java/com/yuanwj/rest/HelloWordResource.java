package com.yuanwj.rest;

import com.yuanwj.config.ConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by bmk on 17-8-16.
 */
@RestController
@RequestMapping(value = "/api/v1/yuanwj/")
public class HelloWordResource {

    @Inject
    private ConfigProperties configProperties;

    private static final Logger LOG= LoggerFactory.getLogger(HelloWordResource.class);
    @Inject
    private Environment environment;

    @RequestMapping(value = "helloWorld")
    public String helloWorld(){
        String aaa=null;
        System.out.println(aaa.length());
        return configProperties.getRandomString();
    }

}
