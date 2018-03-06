package com.iphotowalking.samples.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author jianglz
 * @since 2018/3/6.
 */
@Component
@PropertySource("classpath:config/base-${spring.profiles.active}.yml")
@ConfigurationProperties(prefix = "app")
public class MyConifg {
    
    @Value("${version}")
    private String version;
    @Value("${name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
