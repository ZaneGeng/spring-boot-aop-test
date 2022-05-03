package com.demo.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * 定义一个切面类
 */
@Aspect
@Component
public class AspectHandler {
    /**
     * 切入点：待增强的方法
     */
    @Pointcut("execution(* com.demo..*.*(..))")
    public void txPoint() {
    }

    /**
     * 前置通知：
     * 1、方法是public，无返回值void
     * 2、方法可以无参数，也可以有参数：JoinPoint连接点
     * <p>
     * 功能：在目标方法执行之前执行，不会影响目标方法的执行，不会修改目标方法的执行结果
     */
    @Before("txPoint()")
    public void before(JoinPoint jPoint) {
        // 切面的代码
        System.out.println();
        System.out.println("==========BEGIN 前置通知【日志功能】==========" + new Date());
        System.out.println("代理对象：" + jPoint.getThis().getClass());
        System.out.println("目标对象target" + jPoint.getTarget().getClass());
        System.out.println("被增强方法的参数" + Arrays.toString(jPoint.getArgs()));
        System.out.println("连接点方法签名" + jPoint.getSignature());
        System.out.println("获取方法名称" + jPoint.getSignature().getName());
        if ("index".equals(jPoint.getSignature().getName())) {
            System.out.println("增强的的确是index方法");
        }
        System.out.println("当前连接点类型" + jPoint.getKind());
        System.out.println("==========END 前置通知【开始事务】==========");
        System.out.println();
    }


    /**
     * 后置通知
     * <p>
     * 属性：
     * value切入点表达式
     * returning自定义变量，必须与参数名一致
     * <p>
     * 执行时间：
     * 在目标方法执行后执行
     * <p>
     * 注意：
     * JoinPoint jPoint必须放到第一个参数，否则报错
     *
     * @param result
     */
    @AfterReturning(value = "txPoint()", returning = "result")
    public void afterReturning(JoinPoint jPoint, Object result) {

        // 获取目标方法返回值
        Integer response = (Integer) result;
        response += 4000;

        System.out.println();
        System.out.println("==========BEGIN 后置通知【提交事务】==========");
        System.out.println(jPoint.getSignature().getName() + "业务方法修改后内容：" + response + ",原始result值：" + result);
        System.out.println("==========END 后置通知【翻译数据字典功能也在此执行】==========");
        System.out.println();

    }


    /**
     * 环绕通知
     *
     * 注意：不要和 @Before、@AfterReturning一起使用！
     * 特点：
     * 1、在目标方法前后都能增强
     * 2、控制目标方法是否执行：pjp.proceed()
     * 3、修改目标方法的执行结果
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("txPoint()")
    public Object aroud(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println();
        System.out.println();
        System.out.println("###################BEGIN 环绕通知###################");
        long start = System.currentTimeMillis();

        // 获取目标方法的参数值
        Object args[] = pjp.getArgs();
        System.out.println("环绕通知：目标方法的参数值:" + args[0]);

        // 执行目标方法，可以修改这个返回值
        Object methodResult = pjp.proceed();
        Integer response = (Integer) methodResult;
        response += 4000;

        long end = System.currentTimeMillis();
        System.out.println("返回值原值=" + methodResult + "，环绕通知修改后的返回值：" + response);
        System.out.println("目标方法耗时" + (end - start) + "ms");

        // 返回结果
        System.out.println("###################END 环绕通知###################");
        return response;
    }


    /**
     * 异常通知
     *
     * 特点：
     * 1、目标方法无异常不执行，有异常才执行
     * 2、不能对异常进行处理，这里只能是记录日常，并做一些报警功能
     * 3、报错了话，就不会执行环绕通知pjp.proceed()之后的内容了
     *
     * 插入点：
          try {
            before(),afterReturning()，aroud()
          }catch (Exception e){
              afterThrowing(e)  增强插入到这里
          }finally{
              after()
          }
     * @param e
     */
    @AfterThrowing(value = "txPoint()",throwing = "e")
    public void afterThrowing(Exception e) {

        System.out.println();
        System.out.println("###################BEGIN 异常通知###################");

        // todo 通知管理员，这里只能捕获异常，但是不能处理异常
        System.out.println("异常内容是：可以发信息给管理员："+e.getMessage());

        System.out.println("###################END 异常通知###################");
        System.out.println();
    }


    /**
     * 最终通知
     *
     * 特点：
     * 1、在目标方法后执行
     * 2、总会被执行，无论目标方法是否抛异常
     * 3、用来收尾工作：例如清除临时数据，变量等
     *
     * 插入点：
         try {
            before(),afterReturning()，aroud()
         }catch (Exception e){
            afterThrowing(e)  增强插入到这里
         }finally{
            after()
         }
     */
    @After(value = "txPoint()")
    public void after() {

        System.out.println();
        System.out.println("###################BEGIN 最终通知###################");

        System.out.println("无论目标方法成功还是抛出异常，最终通知都会执行，等于放到finally中的增强");

        System.out.println("###################END 最终通知###################");
        System.out.println();
    }
}

