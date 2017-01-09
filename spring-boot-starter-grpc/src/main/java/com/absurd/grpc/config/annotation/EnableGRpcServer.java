package com.absurd.grpc.config.annotation;

import com.absurd.grpc.config.GRpcAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by wangwenwei on 17/1/9.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(GRpcAutoConfiguration.class)
public @interface EnableGRpcServer {
}
