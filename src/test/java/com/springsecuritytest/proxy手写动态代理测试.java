package com.springsecuritytest;

import com.demo.DemoApplication;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import com.demo.service.proxy.UserServiceProxy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: gz
 * @Date: 2022/5/3 15:17
 * @Version: 1.0
 */
@SpringBootTest(classes = DemoApplication.class)
public class proxy手写动态代理测试 {


    /**
     * 测试原始user业务
     */
    @Test
    void userTest() {

        UserService service=new UserServiceImpl();
        service.doSth();
        service.doAfter();
    }


    /**
     * 测试添加了User动态代理后的效果
     */
    @Test
    void proxyUserTest() {
        // UserService动态代理
        UserService service=new UserServiceProxy();
        service.doSth();
    }

}
