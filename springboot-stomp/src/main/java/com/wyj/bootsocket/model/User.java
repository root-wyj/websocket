package com.wyj.bootsocket.model;

/**
 * 
 * @author wuyingjie
 * @date 2017年10月31日
 */

public class User {
	private String name;
	private String pswd;
	
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
}
