package com.absurd.dubbo.api;

import com.absurd.dubbo.api.dto.UserDTO;

import java.util.concurrent.Future;

/**
 * Created by wangwenwei on 17/1/4.
 */
public interface DemoService {

    String sayHello(String name);

    UserDTO getUser(Long id);

    Future<UserDTO> asyncUser(Long id);

}
