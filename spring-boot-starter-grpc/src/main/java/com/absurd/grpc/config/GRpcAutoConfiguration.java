package com.absurd.grpc.config;

import com.absurd.grpc.config.annotation.GRpcService;
import com.absurd.grpc.config.properties.GRpcServerProperties;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangwenwei on 17/1/9.
 */
@Configuration
@EnableConfigurationProperties(GRpcServerProperties.class)
@AutoConfigureOrder
public class GRpcAutoConfiguration {
    @Bean
    //仅仅在当前上下文中存在GRpcService对象时，才会实例化一个Bean
    @ConditionalOnBean(annotation = GRpcService.class)
    public GRpcServerRunner grpcServerRunner(GRpcServerBuilderConfigurer configurer){
        return new GRpcServerRunner(configurer);
    }

    @Bean
    //仅仅在当前上下文中不存在GRpcServerBuilderConfigurer时，才会实例化一个Bean
    @ConditionalOnMissingBean(  GRpcServerBuilderConfigurer.class)
    public GRpcServerBuilderConfigurer serverBuilderConfigurer(){
        return new GRpcServerBuilderConfigurer();
    }
}
