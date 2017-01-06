package com.absurd.motan.config.properties;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;

/**
 * Created by wangwenwei on 17/1/6.
 */
@Configuration
@EnableConfigurationProperties(
        {
                MotanRegistry.class
        }
)
@Order(Ordered.LOWEST_PRECEDENCE)
public class MotanCommandLineRunner implements CommandLineRunner {

    @Autowired
    private MotanRegistry motanRegistry;

    @Override
    public void run(String... args) throws Exception {

        if (!motanRegistry.getRegProtocol().toLowerCase().equals("local")) {
            // 开启注册中心
            MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        }
    }

}
