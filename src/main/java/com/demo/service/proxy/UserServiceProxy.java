package com.demo.service.proxy;

import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;

/**
 * User的动态代理
 *
 * @Description:
 * @Author: gz
 * @Date: 2022/5/3 15:28
 * @Version: 1.0
 */
public class UserServiceProxy implements UserService {

    /**
     * 真正的user目标
     */
    UserService realTarget = new UserServiceImpl();

    @Override
    public void doSth() {
        // 业务代码执行前
        System.out.println("=========动态代理：记录日志==========");

        // 执行业务代码
        realTarget.doSth();

        // 业务代码执行后
        System.out.println("=========动态代理：事务处理==========");

    }

    @Override
    public void doAfter() {

    }
}
