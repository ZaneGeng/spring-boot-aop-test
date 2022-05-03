package com.demo.controller;


import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopTestController {


    @RequestMapping("/aop/{name}")
    public int index(@PathVariable("name") String name) {

        System.out.println("Begin 目标方法index业务代码");
        int a = 0;
        a += 300;
        // 模拟异常，测试异常通知功能
        //int b =1/0;
        System.out.println("a的值是：" + a);
        System.out.println("End 目标方法业index务代码");
        return a;
    }


}
