package com.wyj.bootsocket.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import com.wyj.bootsocket.websocket.MyChannelInterceptor;
import com.wyj.bootsocket.websocket.MyDecoratorFactory;

/**
 * 
 * @author wuyingjie
 * @date 2017年10月31日
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic", "/user");
		registry.setApplicationDestinationPrefixes("/socket");
		registry.setUserDestinationPrefix("/user");
		registry.setPathMatcher(new AntPathMatcher("."));
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/socketconnect").withSockJS();
	}
	
	@Override
	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
		return true;
	}
	
	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
		registration.addDecoratorFactory(new MyDecoratorFactory());
	}
	
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.interceptors(new MyChannelInterceptor());
	}
	
	@Override
	public void configureClientOutboundChannel(ChannelRegistration registration) {
		// TODO Auto-generated method stub
		super.configureClientOutboundChannel(registration);
	}

}
