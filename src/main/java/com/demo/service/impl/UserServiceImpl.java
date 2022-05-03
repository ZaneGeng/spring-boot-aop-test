package com.demo.service.impl;

import com.demo.service.UserService;

/**
 * @Description:
 * @Author: gz
 * @Date: 2022/5/3 15:18
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public void doSth() {
        System.out.println("▲我是doSth实际业务处理▲");

    }

    @Override
    public void doAfter() {
        System.out.println("▲我是doAfter实际业务处理▲");
    }
}
