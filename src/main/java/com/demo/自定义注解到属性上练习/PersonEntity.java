package com.demo.自定义注解到属性上练习;

import lombok.Data;

/**
 * @Description:
 * @Author: gz
 * @Date: 2022/5/4 14:08
 * @Version: 1.0
 */
@Data
public class PersonEntity {

    @ZaneField(name = "耿正",age = 22,gender = "男")
    String name;

    int age;

    String gender;


}
