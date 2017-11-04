package com.wyj.bootsocket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author wuyingjie
 * @date 2017年10月31日
 */

@RestController
@RequestMapping(produces="application/json;charset=utf-8")
public class TestController {

	@RequestMapping("/test/hello")
	public String hello() {
		return "success";
	}
}
