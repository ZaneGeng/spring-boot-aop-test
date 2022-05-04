package com.demo.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 定义aop切面，实现ZaneTransactionAnnotation自定义注解功能
 */
@Aspect
@Component
public class ZaneTransactionAopAnnotation {

    //切入点：增强标有ZaneAnnotation注解的方法
    // @annotation：用于匹配当前执行方法持有指定注解的方法；
    @Pointcut(value = "@annotation(com.demo.annotation.ZaneTransactionAnnotation)")
    public void transactionAnnotation() {

    }

    /**
     * 环绕通知
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("transactionAnnotation()")
    public Object aroud(ProceedingJoinPoint pjp) {

        try {
            System.out.println("=======开启事务，需要自己写个事务的util工具=======");
            // 执行目标方法
            Object methodResult = pjp.proceed();
            System.out.println("=======提交事务，需要自己写个事务的util工具=======");
            return methodResult;

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("=======回滚事务，需要自己写个事务的util工具=======");
        }

        return pjp;
    }

}
