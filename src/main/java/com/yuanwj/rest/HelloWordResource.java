package com.yuanwj.rest;

import com.yuanwj.config.ConfigProperties;
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

    @Inject
    private Environment environment;

    @RequestMapping(value = "helloWorld")
    public String helloWorld(){
        System.out.println(configProperties.getRandomString());
        System.out.println(environment.getProperty("server.port"));
        return configProperties.getRandomString();
    }

}
