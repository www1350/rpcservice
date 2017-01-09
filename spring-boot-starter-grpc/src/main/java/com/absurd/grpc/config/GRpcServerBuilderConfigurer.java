package com.absurd.grpc.config;

import io.grpc.ServerBuilder;

/**
 * Created by wangwenwei on 17/1/9.
 */
public class GRpcServerBuilderConfigurer {
    public ServerBuilder<?> configure(ServerBuilder<?> serverBuilder){
        return serverBuilder;
    }
}
