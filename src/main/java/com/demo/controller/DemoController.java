package com.demo.controller;


import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
 

	@RequestMapping("/index")
	public void index() {
		System.out.println("我是index接口");
		UserService userService=new UserServiceImpl();
		userService.doSth();
	}



	

}
