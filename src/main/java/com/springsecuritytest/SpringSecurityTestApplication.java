package com.springsecuritytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityTestApplication {

    public static void main(String[] args) {
        System.out.println("项目启动完成！DemoController");
        SpringApplication.run(SpringSecurityTestApplication.class, args);
    }

}
