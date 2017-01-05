package com.absurd.motan.config;

import com.absurd.motan.config.properties.MotanConsumeConfig;
import com.absurd.motan.config.properties.MotanProtocol;
import com.absurd.motan.config.properties.MotanProviderConfig;
import com.absurd.motan.config.properties.MotanRegistry;
import com.weibo.api.motan.config.ProtocolConfig;
import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicRefererConfigBean;
import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangwenwei on 17/1/5.
 */
@Configuration
@EnableConfigurationProperties(
        {
                MotanProviderConfig.class,
                MotanProtocol.class,
                MotanRegistry.class,
                MotanConsumeConfig.class
        }
)
public class MotanAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(MotanAutoConfiguration.class);

    @Autowired
    private MotanProviderConfig motanProviderConfig;

    @Autowired
    private MotanProtocol motanProtocol;

    @Autowired
    private MotanConsumeConfig motanConsumeConfig;

    @Autowired
    private MotanRegistry motanRegistry;

    /**
     * 声明Annotation用来指定需要解析的包名
     *
     * @return
     */
    @Bean
    public static AnnotationBean montanAnnotationBean(@Value("${motan.annotation.package}") String packageName) {
        AnnotationBean bean = new AnnotationBean();
        bean.setPackage(packageName);
        logger.info("[MotanAutoConfiguration] {}", packageName);
        return bean;
    }

    /**
     * 协议配置
     *
     * @return
     */
    @Bean(name = "serverMotan")
    public ProtocolConfigBean protocolConfig() {
        ProtocolConfigBean config = new ProtocolConfigBean();
        config.setDefault(motanProtocol.isDefault());
        config.setId(motanProtocol.getId());
        config.setName(motanProtocol.getName());// 采用motan协议
        config.setMaxWorkerThread(motanProtocol.getMaxworkerthread());// 最大线程
        config.setMinWorkerThread(motanProtocol.getMinworkerthread());// 最少线程
        config.setMaxContentLength(motanProtocol.getMaxcontentlength());// 内容大小
        config.setHaStrategy(motanProtocol.getHaStrategy());
        config.setLoadbalance(motanProtocol.getLoadbalance());
        return config;
    }

    /**
     * 需要本地配置zookeeper注册中心,并运行
     *
     * @return
     */
    @Bean(name = "registryConfig")
    public RegistryConfigBean registryConfig() {
        RegistryConfigBean config = new RegistryConfigBean();
        config.setDefault(motanRegistry.isDefault());// 不加就报错
        config.setRegProtocol(motanRegistry.getRegProtocol());// 采用zookeeper注册中心
        config.setName(motanRegistry.getName());
        config.setAddress(motanRegistry.getAddress());// 本地的zookeeper
        config.setRegister(motanRegistry.isRegister());
        config.setSubscribe(motanRegistry.isSubscribe());
        return config;
    }

    @Bean(name = "basicServiceConfig")
    public BasicServiceConfigBean baseServiceConfig(ProtocolConfig protocol) {
        BasicServiceConfigBean config = new BasicServiceConfigBean();
        config.setExport("serverMotan:"+motanProviderConfig.getPort());// 在20880这个端口暴漏
        config.setAccessLog(motanProviderConfig.getAccesslog());
        config.setRegistry("registryConfig");// 采用上面定义好的
        config.setThrowException(motanProviderConfig.getThrowException());
        config.setCheck(motanProviderConfig.getCheck());
        config.setShareChannel(motanProviderConfig.getShareChannel());
        config.setModule(motanProviderConfig.getModule());
        config.setProtocol(protocol);
        config.setApplication(motanProviderConfig.getApplication());
        config.setGroup(motanProviderConfig.getGroup());
        return config;
    }


    @Bean(name = "basicRefererConfig")
    public BasicRefererConfigBean basicRefererConfig(){
        BasicRefererConfigBean config = new BasicRefererConfigBean();
        config.setAccessLog(motanConsumeConfig.getAccesslog());
        config.setGroup(motanConsumeConfig.getGroup());
        config.setModule(motanConsumeConfig.getModule());
        config.setThrowException(motanConsumeConfig.getThrowException());
        config.setCheck(motanConsumeConfig.getCheck());
        config.setShareChannel(motanProviderConfig.getShareChannel());
        config.setProtocol("serverMotan");
        config.setApplication(motanConsumeConfig.getApplication());
        config.setRegistry("registryConfig");
        return config;
    }
}
