package com.wyj.bootsocket.websocket;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

/**
 * 
 * @author wuyingjie
 * @date 2017年11月3日
 */
public class MyChannelInterceptor extends ChannelInterceptorAdapter{
	@Override
	public boolean preReceive(MessageChannel channel) {
		System.out.println("MyChannelInterceptor preReceive. channel:"+channel);
		return super.preReceive(channel);
	}
	
	@Override
	public Message<?> postReceive(Message<?> message, MessageChannel channel) {
		System.out.println("MyChannelInterceptor postReceive. message:"+message+", channel:"+channel);
		return super.postReceive(message, channel);
	}
	
	@Override
	public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
		System.out.println("MyChannelInterceptor afterReceiveCompletion. channel:"+channel+", message:"+message+", ex:"+ex);
	}
	
	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		System.out.println("MyChannelInterceptor preSend. channel:"+channel+", message:"+message);
		return super.preSend(message, channel);
	}
	
	@Override
	public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
		System.out.println("MyChannelInterceptor postSend. channel:"+channel+", message:"+message+", send:"+sent);
	}
	
	@Override
	public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
		System.out.println("MyChannelInterceptor afterSendCompletion. channel:"+channel+", message:"+message+", ex:"+ex);
	}
	
}
