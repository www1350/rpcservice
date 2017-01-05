package com.absurd.dubbo.web;

import com.absurd.dubbo.api.DemoService;
import com.absurd.dubbo.api.dto.UserDTO;
import com.alibaba.dubbo.config.annotation.Reference;
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

    @Reference(version = "1.0.0")
    private DemoService demoService;
    @RequestMapping(value={"hello/{user}"})
    @ResponseBody
    public String hello(@PathVariable String user){
        return demoService.sayHello(user);
    }

    @RequestMapping(value={"user/{id}"})
    @ResponseBody
    public UserDTO getUser(@PathVariable Long id){
        return demoService.getUser(id);
    }

}
