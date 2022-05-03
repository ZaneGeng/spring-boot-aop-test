package com.demo.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class ZaneAopAnnotation {

    //切入点：增强标有ZaneAnnotation注解的方法
    // @annotation：用于匹配当前执行方法持有指定注解的方法；
    @Pointcut(value = "@within(com.demo.annotation.ZaneAnnotation)")
    public void logAnnotation() {
        System.out.println("pointCut签名。。。");
    }

    //前置通知
    @Before("logAnnotation()")
    public void deBefore(JoinPoint jPoint) throws Throwable {
        // 切面的代码
        System.out.println();
        System.out.println("==========BEGIN 前置通知【日志功能】==========" + new Date());
        System.out.println("获取方法名称" + jPoint.getSignature().getName());
        System.out.println("==========END 前置通知【开始事务】==========");
        System.out.println();
    }

    //后置通知
    @AfterReturning(value = "logAnnotation()", returning = "result")
    public void afterReturning(JoinPoint jPoint, Object result) {

        System.out.println();
        System.out.println("==========BEGIN 后置通知【提交事务】==========");
        System.out.println("后置通知业务");
        System.out.println("==========END 后置通知【翻译数据字典功能也在此执行】==========");
        System.out.println();
    }

}
