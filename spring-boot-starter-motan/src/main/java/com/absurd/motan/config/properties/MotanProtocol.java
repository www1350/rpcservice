package com.absurd.motan.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wangwenwei on 17/1/4.
 */
@ConfigurationProperties(prefix = "motan.protocol")
public class MotanProtocol {

    private String id ="myMotan";
    /**
     * 接口协议
     * dubbo
     * hessian
     * rmi
     *
     */
    private String name = "motan";

    private int maxworkerthread = 500;

    private int minworkerthread = 20;

    private int maxcontentlength = 1048576;

    private int threads =100;

    private boolean isDefault = true;

    private String serialization="hessian2";

    /**
     * 目前支持的负载均衡策略有：
     * ActiveWeight(缺省)
     * <motan:protocol ... loadbalance="activeWeight"/>
     * 低并发度优先： referer 的某时刻的 call 数越小优先级越高
     * 由于 Referer List 可能很多，比如上百台，如果每次都要从这上百个 Referer 或者最低并发的几个，性能有些损耗，因此 random.nextInt(list.size()) 获取一个起始的 index，然后获取最多不超过 MAX_REFERER_COUNT 的状态是 isAvailable 的 referer 进行判断 activeCount.
     *
     * Random
     * <motan:protocol ... loadbalance="random"/>
     * 随机，按权重设置随机概率。
     * 在一个截面上碰撞的概率高，但调用量越大分布越均匀，而且按概率使用权重后也比较均匀，有利于动态调整提供者权重。
     *
     * RoundRobin
     * <motan:protocol ... loadbalance="roundrobin"/>
     * 轮循，按公约后的权重设置轮循比率
     *
     * LocalFirst
     * <motan:protocol ... loadbalance="localFirst"/>
     * 本地服务优先获取策略，对referers根据ip顺序查找本地服务，多存在多个本地服务，获取Active最小的本地服务进行服务。
     * 当不存在本地服务，但是存在远程RPC服务，则根据ActivWeight获取远程RPC服务
     * 当两者都存在，所有本地服务都应优先于远程服务，本地RPC服务与远程RPC服务内部则根据ActiveWeight进行
     *
     * Consistent
     * <motan:protocol ... loadbalance="consistent"/>
     * 一致性 Hash，相同参数的请求总是发到同一提供者
     *
     * ConfigurableWeight
     * <motan:protocol ... loadbalance="configurableWeight"/>
     * 权重可配置的负载均衡策略
     */
    private String loadbalance = "roundrobin";

    /**
     * 目前支持的集群容错策略有：
     * Failover 失效切换（缺省）
     * <motan:protocol ... haStrategy="failover"/>
     * 失败自动切换，当出现失败，重试其它服务器。
     *
     * Failfast 快速失败
     * <motan:protocol ... haStrategy="failfast"/>
     * 快速失败，只发起一次调用，失败立即报错。
     */
    private String haStrategy = "failfast";




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxworkerthread() {
        return maxworkerthread;
    }

    public void setMaxworkerthread(int maxworkerthread) {
        this.maxworkerthread = maxworkerthread;
    }

    public int getMinworkerthread() {
        return minworkerthread;
    }

    public void setMinworkerthread(int minworkerthread) {
        this.minworkerthread = minworkerthread;
    }

    public int getMaxcontentlength() {
        return maxcontentlength;
    }

    public void setMaxcontentlength(int maxcontentlength) {
        this.maxcontentlength = maxcontentlength;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getSerialization() {
        return serialization;
    }

    public void setSerialization(String serialization) {
        this.serialization = serialization;
    }

    public String getLoadbalance() {
        return loadbalance;
    }

    public void setLoadbalance(String loadbalance) {
        this.loadbalance = loadbalance;
    }

    public String getHaStrategy() {
        return haStrategy;
    }

    public void setHaStrategy(String haStrategy) {
        this.haStrategy = haStrategy;
    }
}
