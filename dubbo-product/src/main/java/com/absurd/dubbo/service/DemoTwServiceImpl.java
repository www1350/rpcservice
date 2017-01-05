package com.absurd.dubbo.service;

import com.absurd.dubbo.api.DemoService;
import com.absurd.dubbo.api.dto.UserDTO;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by wangwenwei
 * @date 2017/1/5 12:17
 */
@Service(version="1.0.0",group = "demo2")
public class DemoTwServiceImpl implements DemoService{
    @Override
    public String sayHello(String name) {
        return "Hello 2 " + name;
    }

    @Override
    public UserDTO getUser(Long id) {
        UserDTO userDTO =new UserDTO();
        userDTO.setId(id);
        userDTO.setUserName("www2");
        userDTO.setPassword("fsf#@#FDS");
        return userDTO;
    }
}
