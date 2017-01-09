package com.absurd.grpc;

import com.absurd.grpc.pro.User;
import com.absurd.grpc.pro.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangwenwei on 17/1/9.
 */
public class UserClient {

    private final ManagedChannel channel;
    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;


    public UserClient(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();

        blockingStub = UserServiceGrpc.newBlockingStub(channel);
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public  void register(String name){
        User.UserInfo userInfo = User.UserInfo.newBuilder().setUserName(name).build();
        User.RegisterReply response = blockingStub.register(userInfo);
        System.out.println(response.getMessage());

    }

    public static void main(String[] args) throws InterruptedException {
        UserClient client = new UserClient("127.0.0.1",6565);
        for(int i=0;i<5;i++){
            client.register("www:"+i);
        }


    }
}
