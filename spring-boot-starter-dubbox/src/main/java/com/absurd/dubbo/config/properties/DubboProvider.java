package com.absurd.dubbo.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wangwenwei on 17/1/4.
 */
@ConfigurationProperties(prefix = "dubbo.provider")
public class DubboProvider {

    /**
     * 服务的超时时间,单位毫秒
     */
    private int timeout = 10000;

    /**
     * 调用失败重试次数
     */
    private int retries = 0;

    /**
     * 是否延迟暴露,-1表示不延迟暴露
     */
    private int delay = -1;

    /**
     * 集群容错模式：
     * Failfast Cluster
     * 快速失败，只发起一次调用，失败立即报错。 通常用于非幂等性的写操作，比如新增记录。
     */
    private String cluster = "failfast";

    /**
     * 负载均衡
     * 缺省为random随机调用。
     * Random LoadBalance
     * 随机，按权重设置随机概率。
     * 在一个截面上碰撞的概率高，但调用量越大分布越均匀，而且按概率使用权重后也比较均匀，有利于动态调整提供者权重。
     */
    private String loadbalance ="random";

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getLoadbalance() {
        return loadbalance;
    }

    public void setLoadbalance(String loadbalance) {
        this.loadbalance = loadbalance;
    }
}
