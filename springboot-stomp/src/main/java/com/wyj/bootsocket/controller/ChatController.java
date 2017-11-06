package com.wyj.bootsocket.controller;

import com.wyj.bootsocket.model.Greeting;
import com.wyj.bootsocket.model.Room;
import com.wyj.bootsocket.model.User;
import com.wyj.bootsocket.model.UserStateInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
/* 	topic/type.target 表示广播
	user/type.target 表示 对某个用户
	
	type: 就是表示游戏中的哪种消息，出牌？聊天？动作？还是其他的什么
	target：表示游戏中接收消息的对象，就是给谁发消息，可能是 某个房间，某个讨论组，某个人什么的
*/
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
    public Greeting signIn(@Header(value = "name")String name, @Header(value="simpSessionId")String sessionId ) {
//        return new Greeting(name+" come in");
    	User u = new User(name, "111");
    	u.setInfo(new UserStateInfo(u));
    	User.add(sessionId, u);
        simpMessageSendingOperations.convertAndSend("/topic/chat/message", new Greeting(name+" come in"));
        return null;
    }



    @MessageMapping("/chat")
//    @SendTo("/topic/chat/message")
    public Greeting say(@Header(value="simpSessionId")String sessionId, Greeting content) {
//        return new Greeting(name+": "+content.getContent());
        simpMessageSendingOperations.convertAndSend("/topic/chat/message", new Greeting(User.get(sessionId).getName()+": "+content.getContent()));
        return null;
    }
    
    @MessageMapping("/createRoom")
    public String createRoom(@Header(value="simpSessionId")String sessionId) {
    	User u = User.get(sessionId);
    	Room room = new Room((int)(Math.random()*100)+1+"", u);
    	u.getInfo().setRoom(room);
    	Room.add(room);
    	return room.getId();
    }
    
    @MessageMapping("/chatInRoom")
    public void chatInRoom(@Header(value="simpSessionId")String sessionId, Greeting content) {
    	User u = User.get(sessionId);
    	simpMessageSendingOperations.convertAndSend("/topic/chat.room."+u.getInfo().getRoom().getId(), new Greeting(u.getName()+": "+content.getContent()));
    }
    
    @MessageMapping("/inRoom")
    public String inRoom(@Header(value="simpSessionId")String sessionId, @Header(value="roomId")String roomId) {
    	User user = User.get(sessionId);
    	user.getInfo().setRoom(Room.get(roomId));
    	simpMessageSendingOperations.convertAndSend("/topic/chat.room."+user.getInfo().getRoom().getId(), new Greeting(user.getName()+": come in"));
    	return roomId;
    }

}
