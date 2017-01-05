package com.absurd.dubbo.web;

import com.absurd.dubbo.api.DemoService;
import com.absurd.dubbo.api.dto.UserDTO;
import com.absurd.dubbo.config.DubboAutoConfiguration;
import com.alibaba.dubbo.config.annotation.Reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangwenwei on 17/1/5.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Reference(version = "1.0.0",group = "demo1" ,async=true,sent = true)
    private DemoService demo1Service;

    @Reference(version = "1.0.0",group = "demo2" )
    private DemoService demo2Service;

    @RequestMapping(value={"hello/{user}"})
    @ResponseBody
    public String hello(@PathVariable String user){
        return demo1Service.sayHello(user);
    }

    @RequestMapping(value={"user/{id}"})
    @ResponseBody
    public UserDTO getUser(@PathVariable Long id){
        return demo1Service.getUser(id);
    }


    @RequestMapping(value={"hello2/{user}"})
    @ResponseBody
    public String hello2(@PathVariable String user){
        return demo2Service.sayHello(user);
    }

    @RequestMapping(value={"user2/{id}"})
    @ResponseBody
    public UserDTO getUser2(@PathVariable Long id){
        return demo2Service.getUser(id);
    }

}
