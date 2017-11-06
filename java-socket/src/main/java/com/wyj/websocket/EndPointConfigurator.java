package com.wyj.websocket;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * 
 * @author wuyingjie
 * @date 2017年11月2日
 */

public class EndPointConfigurator extends ServerEndpointConfig.Configurator{

	@Override
	public boolean checkOrigin(String originHeaderValue) {
		System.out.println("EndPointConfigurator.checkOrigin");
		return super.checkOrigin(originHeaderValue);
	}

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		System.out.println("EndPointConfigurator.modifyHandshake");
		super.modifyHandshake(sec, request, response);
		System.out.println("userProperties:"+sec.getUserProperties());
		System.out.println("httpSession:"+request.getHttpSession());
		System.out.println("queryStr:"+request.getQueryString()+", headers:"+request.getHeaders()+", parameterMap:"+request.getParameterMap());
		System.out.println(response);
	}
	
}
