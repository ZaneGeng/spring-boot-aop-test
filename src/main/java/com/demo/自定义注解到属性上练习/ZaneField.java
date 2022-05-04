package com.demo.自定义注解到属性上练习;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解：字段属性
 *
 * 不需要aop，因为用这个自定义注解的是在类中的属性，还进不了方法启动不了aop功能
 */
//表示次注解仅可以标注在属性
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZaneField {

    String name() default " ";

    int age() default 21;

    String gender();

}
