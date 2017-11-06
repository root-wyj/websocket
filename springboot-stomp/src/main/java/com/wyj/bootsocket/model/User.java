package com.wyj.bootsocket.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author wuyingjie
 * @date 2017年10月31日
 */

public class User {
	private String name;
	private String pswd;
	
	private UserStateInfo info;
	
	public User() {}
	
	public User(String name, String pswd) {
		this.name = name;
		this.pswd = pswd;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPswd() {
		return pswd;
	}
	
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
	public UserStateInfo getInfo() {
		return info;
	}
	
	public void setInfo(UserStateInfo info) {
		this.info = info;
	}
	
	
	private static Map<String, User> userCache = Collections.synchronizedMap(new HashMap<>());
	
	public static void add(String sessionId, User user) {
		userCache.put(sessionId, user);
	}
	
	public static User get(String sessionId) {
		return userCache.get(sessionId);
	}
	
	public static User remove(String sessionId) {
		return userCache.remove(sessionId);
	}
}
