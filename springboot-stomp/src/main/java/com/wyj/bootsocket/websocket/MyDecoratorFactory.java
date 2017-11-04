package com.wyj.bootsocket.websocket;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

/**
 * 
 * @author wuyingjie
 * @date 2017年11月3日
 */

public class MyDecoratorFactory implements WebSocketHandlerDecoratorFactory{

	@Override
	public WebSocketHandler decorate(WebSocketHandler handler) {
		return new MyWebSocketHandler(handler);
	}

}
