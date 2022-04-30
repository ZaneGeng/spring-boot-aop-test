package com.springsecuritytest.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
 

	@RequestMapping("/index")
	public void index() {
		System.out.println("我是index接口");
	}
	

}
