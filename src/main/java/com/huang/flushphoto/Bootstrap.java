package com.huang.flushphoto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author huangjihui
 * @Date 2018/8/22 18:26
 */
@SpringBootApplication
@ImportResource({"classpath:application-context.xml"})
public class Bootstrap {
    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) {
        LOGGER.info("start flushphoto...");

        new SpringApplicationBuilder().sources(Bootstrap.class).run(args);
        LOGGER.info("flushphoto start success...");
    }
}
