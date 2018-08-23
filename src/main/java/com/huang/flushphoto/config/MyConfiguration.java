package com.huang.flushphoto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author huangjihui
 * @Date 2018/8/23 10:09
 */
@Configuration
public class MyConfiguration {
    @Value("${tomcatport:8901}")
    private int port;

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        return new TomcatEmbeddedServletContainerFactory(this.port);
    }
}
