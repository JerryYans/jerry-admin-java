package com.jerryYan.vue.internal.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@EnableAutoConfiguration
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 设置js跨域
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DElETE", "OPTIONS")
                .maxAge(3600);
    }
}
