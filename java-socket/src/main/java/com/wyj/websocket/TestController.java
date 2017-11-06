package com.wyj.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author wuyingjie
 * @date 2017年10月30日
 */
@Controller
@RequestMapping(produces="application/json;charset=utf-8")
public class TestController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String test() {
		
		return "success";
	}

}
