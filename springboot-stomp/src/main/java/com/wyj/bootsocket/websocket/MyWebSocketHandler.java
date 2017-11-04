package com.wyj.bootsocket.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;

/**
 * 
 * @author wuyingjie
 * @date 2017年11月3日
 */

public class MyWebSocketHandler extends WebSocketHandlerDecorator{

	
	
	public MyWebSocketHandler(WebSocketHandler webSocketHandler) {
		super(webSocketHandler);
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("MyWebSocketHandler afterConnectionEstablished");
		super.afterConnectionEstablished(session);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.out.println("MyWebSocketHandler handleMessage");
		System.out.println("MyWebSocketHandler message:"+message);
		super.handleMessage(session, message);
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println("MyWebSocketHandler handleTransportError");
		System.out.println("MyWebSocketHandler exception:"+exception.getMessage());
		super.handleTransportError(session, exception);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.out.println("MyWebSocketHandler afterConnectionClosed");
		System.out.println("MyWebSocketHandler closeStatus:"+closeStatus);
		super.afterConnectionClosed(session, closeStatus);
		
	}

	@Override
	public boolean supportsPartialMessages() {
		System.out.println("MyWebSocketHandler supportsPartialMessages");
		return super.supportsPartialMessages();
	}

}
