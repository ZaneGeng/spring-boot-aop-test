package com.demo.controller;


import com.demo.annotation.ZaneTransactionAnnotation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试自定义事务控制器
 * ps:注释掉AspectHandler，不然影响aop效果
 */
@RestController
public class AopTransactionController {


    @RequestMapping("transaction")
    @ZaneTransactionAnnotation
    public int index() {

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
