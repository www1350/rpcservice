package com.absurd.dubbo.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wangwenwei on 17/1/4.
 */
@ConfigurationProperties(prefix = "dubbo.protocol")
public class DubboProtocol {

    /**
     * 接口协议
     * dubbo
     * hessian
     * rmi
     *
     */
    private String name = "dubbo";
    /**
     * 暴露服务的端口
     */
    private int port = 20880;

    /**
     * 是否记录接口日志
     */
    private boolean accessLog = true;

    /**
     * Dispatcher
     * all 所有消息都派发到线程池，包括请求，响应，连接事件，断开事件，心跳等。
     * direct 所有消息都不派发到线程池，全部在IO线程上直接执行。
     * message 只有请求响应消息派发到线程池，其它连接断开事件，心跳等消息，直接在IO线程上执行。
     * execution 只请求消息派发到线程池，不含响应，响应和其它连接断开事件，心跳等消息，直接在IO线程上执行。
     * connection 在IO线程上，将连接断开事件放入队列，有序逐个执行，其它消息派发到线程池。
     */
    private String dispatcher = "all";

    /**
     * ThreadPool
     * fixed 固定大小线程池，启动时建立线程，不关闭，一直持有。(缺省)
     * cached 缓存线程池，空闲一分钟自动删除，需要时重建。
     * limited 可伸缩线程池，但池中的线程数只会增长不会收缩。(为避免收缩时突然来了大流量引起的性能问题)。
     */
    private String threadpool = "fixed";


    private int threads =100;

    /**
     *
     */
    private String server="netty";

    private String serialization="hessian2";

    private String charset="UTF-8";



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isAccessLog() {
        return accessLog;
    }

    public void setAccessLog(boolean accessLog) {
        this.accessLog = accessLog;
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    public String getThreadpool() {
        return threadpool;
    }

    public void setThreadpool(String threadpool) {
        this.threadpool = threadpool;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getSerialization() {
        return serialization;
    }

    public void setSerialization(String serialization) {
        this.serialization = serialization;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
