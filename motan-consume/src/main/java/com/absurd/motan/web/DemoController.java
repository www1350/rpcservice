package com.absurd.motan.web;

import com.absurd.dubbo.api.DemoService;
import com.absurd.dubbo.api.dto.UserDTO;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wangwenwei on 17/1/5.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @MotanReferer(basicReferer = "basicRefererConfig",group = "demo")
    private DemoService demo1Service;

    @MotanReferer(basicReferer = "basicRefererConfig",group = "demo")
    private DemoService demo2Service;

    @RequestMapping(value={"hello/{user}"})
    @ResponseBody
    public String hello(@PathVariable String user){
        return demo1Service.sayHello(user);
    }

    @RequestMapping(value={"user/{id}"})
    @ResponseBody
    public UserDTO getUser(@PathVariable Long id){
        UserDTO userDTO = demo1Service.getUser(id);
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Future<UserDTO> future = RpcContext.getContext().getFuture();
//        executorService.submit(()->{
//            try {
//                UserDTO  userDTO1 = future.get();
//                logger.info(">>>>>>>>>>>>>>>>>>>>"+userDTO1.getUserName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//
//        });
//        executorService.shutdown();


        return userDTO;
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
