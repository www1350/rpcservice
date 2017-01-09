package com.absurd.grpc.service;

import com.absurd.grpc.config.annotation.GRpcService;
import com.absurd.grpc.pro.User;
import com.absurd.grpc.pro.UserServiceGrpc;

import io.grpc.stub.StreamObserver;

/**
 * Created by wangwenwei on 17/1/9.
 */
@GRpcService
public class UserServiceImpl  extends UserServiceGrpc.UserServiceImplBase{
    @Override
    public void register(User.UserInfo request, StreamObserver<User.RegisterReply> responseObserver) {
        final User.RegisterReply.Builder replyBuilder = User.RegisterReply.newBuilder().setMessage("Hello " + request.getUserName());
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}
