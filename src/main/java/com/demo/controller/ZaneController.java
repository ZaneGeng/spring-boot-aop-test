package com.demo.controller;

import com.demo.annotation.ZaneAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: gz
 * @Date: 2022/5/3 20:32
 * @Version: 1.0
 */
@RestController
@ZaneAnnotation(value = "我是耿正的自定义注解") // 对应：@Pointcut(value = "@within(com.demo.annotation.ZaneAnnotation)")
public class ZaneController {

    @RequestMapping("zane")
//    @ZaneAnnotation(value = "我是耿正的自定义注解")，对应：    @Pointcut(value = "@annotation(com.demo.annotation.ZaneAnnotation)")
    public void zane() {
        System.out.println("我是ZaneController方法的业务代码");


    }
}
