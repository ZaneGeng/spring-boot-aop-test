package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.demo"})
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("项目启动完成！");
        SpringApplication.run(DemoApplication.class, args);
    }

}
