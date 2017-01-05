package com.absurd.dubbo.service;

import com.absurd.dubbo.api.DemoService;
import com.absurd.dubbo.api.dto.UserDTO;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by wangwenwei on 17/1/4.
 */
@Service(version="1.0.0")
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public UserDTO getUser(Long id) {
        UserDTO userDTO =new UserDTO();
        userDTO.setId(id);
        userDTO.setUserName("www");
        userDTO.setPassword("fsf#@#FDS");
        return userDTO;
    }

}
