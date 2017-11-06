package client;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.MessageHandler;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 * 
 * @author wuyingjie
 * @date 2017年10月30日
 */

@ClientEndpoint
public class Client {
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Connection to endPoint: "+session.getBasicRemote());
	}
	
	@OnMessage
	public void onMessage(String message) {
		System.out.println("receive msg:"+message);
	}
	
	@OnError
	public void onError(Throwable t) {
		t.printStackTrace();
	}
	
	public static void main(String[] args) {
		try {
			
			
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			String uri = "ws://localhost:8080/websocket/websocket";
		
			Session session = container.connectToServer(Client.class, new URI(uri));
			session.getBasicRemote().sendText("java client send text");
			session.getBasicRemote().sendText("hahahah");
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
