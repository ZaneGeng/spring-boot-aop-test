package com.demo.自定义注解到属性上练习;


import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

@RestController
public class PersonController {


    @RequestMapping("/person")
    public void person() {

        PersonEntity personEntity = new PersonEntity();

        // 获取类模板(反射）
        Class c = PersonEntity.class;

        // 获取所有字段
        for (Field field : c.getDeclaredFields()) {

            // 判断字段是否有@ZaneField自定义注解
            if (field.getAnnotation(ZaneField.class) != null) {

                // 获取到@ZaneField自定义注解中参数值
                ZaneField annotation = field.getAnnotation(ZaneField.class);
                System.out.println("自定义注解参数值：" + annotation.name() + annotation.age() + annotation.gender());

                // 为personEntitiy赋值（将自定义注解的值注入实体类中）
                personEntity.setName(annotation.name());
                personEntity.setAge(annotation.age());
                personEntity.setGender(annotation.gender());
            }
        }

        // 输出被自定义注解编辑后的实体类
        System.out.println(personEntity.toString());
    }


}
