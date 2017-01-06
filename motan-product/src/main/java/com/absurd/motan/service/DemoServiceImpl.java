package com.absurd.motan.service;

import com.absurd.dubbo.api.DemoService;
import com.absurd.dubbo.api.dto.UserDTO;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Future;

/**
 * Created by wangwenwei on 17/1/4.
 */
@MotanService(basicService = "basicServiceConfig",group = "demo")
public class DemoServiceImpl implements DemoService {
    private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    public String sayHello(String name) {
        logger.info("><>><");
        return "Hello " + name;
    }

    @Override
    public UserDTO getUser(Long id) {
        UserDTO userDTO =new UserDTO();
        userDTO.setId(id);
        userDTO.setUserName("www");
        userDTO.setPassword("fsf#@#FDS");
        logger.info("><>><");
        return userDTO;
    }

    @Override
    public Future<UserDTO> asyncUser(Long id) {
        return null;
    }

}
