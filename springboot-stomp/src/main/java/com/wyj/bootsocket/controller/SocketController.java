package com.wyj.bootsocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyj.bootsocket.model.Greeting;
import com.wyj.bootsocket.model.HelloMessage;

/**
 * 
 * @author wuyingjie
 * @date 2017年10月31日
 */

@RestController
public class SocketController {
	
	@Autowired  
    private SimpMessageSendingOperations simpMessageSendingOperations;
	
	@MessageMapping("/hello")
	@SendTo("/topic/test/greeting")
	@SendToUser
	public Greeting greeting(HelloMessage message) {
		System.err.println(message.getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Greeting("hello! "+message.getName());
	}
	
	@RequestMapping("/test")
	public String test() {
//		simpMessageSendingOperations.convertAndSendToUser("tom", "/message", new Greeting("what the fuck!!"));
		simpMessageSendingOperations.convertAndSend("/topic/test/greeting", new Greeting("yes it is"));
		
		return "success";
	}
}
