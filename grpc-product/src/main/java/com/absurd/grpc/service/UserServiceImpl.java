package com.absurd.grpc.service;

import com.absurd.grpc.config.annotation.GRpcService;
import com.absurd.grpc.pro.User;
import com.absurd.grpc.pro.UserServiceGrpc;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangwenwei on 17/1/9.
 */
@GRpcService
public class UserServiceImpl  extends UserServiceGrpc.UserServiceImplBase{
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void register(User.UserInfo request, StreamObserver<User.RegisterReply> responseObserver) {
        logger.info(">>>>>>>>>"+request.getId()+">>"+request.getUserName());
        final User.RegisterReply.Builder replyBuilder = User.RegisterReply.newBuilder().setMessage("Hello " + request.getUserName());
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}
