package com.wyj.bootsocket.controller;

import com.wyj.bootsocket.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created
 * Author: wyj
 * Email: 18346668711@163.com
 * Date: 2017/11/4
 */
@RestController
public class ChatController {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/signIn")
//    @SendTo("/topic/chat/message")
    public Greeting signIn(@Header(value = "name")String name) {
//        return new Greeting(name+" come in");
        simpMessageSendingOperations.convertAndSend("/topic/chat/message", new Greeting(name+" come in"));
        return null;
    }



    @MessageMapping("/chat")
//    @SendTo("/topic/chat/message")
    public Greeting say(@Header(value="name")String name, Greeting content) {
//        return new Greeting(name+": "+content.getContent());
        simpMessageSendingOperations.convertAndSend("/topic/chat/message", new Greeting(name+": "+content.getContent()));
        return null;
    }


}
