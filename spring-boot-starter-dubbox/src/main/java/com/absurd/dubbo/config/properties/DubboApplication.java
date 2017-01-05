package com.absurd.dubbo.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wangwenwei on 17/1/4.
 */
@ConfigurationProperties(prefix = "dubbo.application")
public class DubboApplication {

    private String name = "sample";

    private String logger = "slf4j";

    private String annotationPackage = "com.absurd.dubbo";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getAnnotationPackage() {
        return annotationPackage;
    }

    public void setAnnotationPackage(String annotationPackage) {
        this.annotationPackage = annotationPackage;
    }
}
