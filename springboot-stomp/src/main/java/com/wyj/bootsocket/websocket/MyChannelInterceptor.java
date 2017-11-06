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
	private static String TAG = "MyChannelInterceptor";
	
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
		//MyChannelInterceptor preSend. channel:ExecutorSubscribableChannel[clientInboundChannel], message:GenericMessage [payload=byte[17],
		// 	headers={simpMessageType=MESSAGE, stompCommand=SEND, nativeHeaders={name=[tom], destination=[/socket/signIn], content-length=[17]},
		//	simpSessionAttributes={}, simpHeartbeat=[J@36e19e37, simpSessionId=ctcleoa1, simpDestination=/socket/signIn}]
//		System.out.println("MyChannelInterceptor preSend. channel:"+channel+", message:"+message);
		
		System.out.println(TAG+" 将会收到消息，类型：["+message.getHeaders().get("stompCommand")+"]，"
				+"客户端headers：["+message.getHeaders().get("nativeHeaders")+"]，"
				+"目的地：["+message.getHeaders().get("simpDestination")+"]，"
				+"sessionId：["+message.getHeaders().get("simpSessionId")+"]，"
				+"simpSessionAttributes：["+message.getHeaders().get("simpSessionAttributes")+"]，"
				+"承载的消息：["+message.getPayload()+"]，");
		return super.preSend(message, channel);
	}
	
	@Override
	public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
//		System.out.println("MyChannelInterceptor postSend. channel:"+channel+", message:"+message+", send:"+sent);
		System.out.println(TAG+" 已会收到消息，类型：["+message.getHeaders().get("stompCommand")+"]，"
				+"客户端headers：["+message.getHeaders().get("nativeHeaders")+"]，"
				+"目的地：["+message.getHeaders().get("simpDestination")+"]，"
				+"sessionId：["+message.getHeaders().get("simpSessionId")+"]，"
				+"sent：["+sent+"]，");
	}
	
	@Override
	public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
//		System.out.println("MyChannelInterceptor afterSendCompletion. channel:"+channel+", message:"+message+", ex:"+ex);
		if (ex != null) {
			System.out.println("已接收完消息，但是发生了异常");
			
			System.out.println(TAG+" 消息信息，类型：["+message.getHeaders().get("stompCommand")+"]，"
					+"客户端headers：["+message.getHeaders().get("nativeHeaders")+"]，"
					+"目的地：["+message.getHeaders().get("simpDestination")+"]，"
					+"sessionId：["+message.getHeaders().get("simpSessionId")+"]，"
					+"sent：["+sent+"]，");
			System.out.println(ex);
		}
	}
	
}
