package com.absurd.grpc.demo;

import com.absurd.grpc.pro.RegisterGrpc;
import com.absurd.grpc.pro.User;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
 * Created by wangwenwei on 17/1/9.
 */
public class UserServer {
    private int port = 50052;
    private Server server;

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }


    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new UserServer.RegisterImpl())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                UserServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    // block 一直到退出程序
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final UserServer server = new UserServer();
        server.start();
        server.blockUntilShutdown();
    }

    private class RegisterImpl extends RegisterGrpc.RegisterImplBase {
        @Override
        public void register(User.UserInfo request, StreamObserver<User.RegisterReply> responseObserver) {
            System.out.println(">>>>>>>>"+request.getUserName());
            User.RegisterReply registerReply = User.RegisterReply.newBuilder().setMessage("hi!"+request.getUserName()).build();
            responseObserver.onNext(registerReply);
            responseObserver.onCompleted();
        }
    }
}
