package com.demo.service.aspect;

import com.demo.annotation.ZaneTransactionAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
    @Around("transactionAnnotation() && @annotation(zaneTransactionAnnotation)")
    public Object aroud(ProceedingJoinPoint pjp,ZaneTransactionAnnotation zaneTransactionAnnotation) {

        System.out.println();
        System.out.println("==========环绕通知【获取：目标方法属性】==========");
        System.out.println("自定义注解zaneTransactionAnnotation参数value值："+zaneTransactionAnnotation.value());
        System.out.println("代理对象：" + pjp.getThis().getClass());
        System.out.println("目标对象target" + pjp.getTarget().getClass());
        System.out.println("被增强方法的参数" + Arrays.toString(pjp.getArgs()));
        System.out.println("连接点方法签名" + pjp.getSignature());
        System.out.println("获取方法名称" + pjp.getSignature().getName());
        if ("index".equals(pjp.getSignature().getName())) {
            System.out.println("增强的的确是index方法");
        }

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
