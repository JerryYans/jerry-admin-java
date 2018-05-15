package com.jerryYan.vue.internal;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jerryYan.vue")
public class InternalStartUp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(InternalStartUp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
