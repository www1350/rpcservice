package com.absurd.motan.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wangwenwei on 17/1/4.
 */
@ConfigurationProperties(prefix = "motan.registry")
public class MotanRegistry {


    private boolean  isDefault =true;
    /**
     * 接口协议
     */
    private String regProtocol = "zookeeper";

    private String name="my_zookeeper";

    /**
     * 注册中心地址
     */
    private String address = "127.0.0.1:2181";

    /**
     * 是否向注册中心注册服务
     */
    private boolean register = true;

    /**
     * 是否向注册中心订阅服务
     */
    private boolean subscribe = true;

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getRegProtocol() {
        return regProtocol;
    }

    public void setRegProtocol(String regProtocol) {
        this.regProtocol = regProtocol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }
}
