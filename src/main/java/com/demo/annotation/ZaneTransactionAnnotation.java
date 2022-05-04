package com.demo.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解：事务（类+方法上使用）
 */
//表示次注解可以标注在类和方法上
@Target({ElementType.METHOD, ElementType.TYPE})
//运行时生效
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZaneTransactionAnnotation {
    //定义一个变量，可以接受参数
    String value() default " ";
}
