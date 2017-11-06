package com.wyj.bootsocket.model;

/**
 * 
 * @author wuyingjie
 * @date 2017年11月6日
 */

public class UserStateInfo {
	
	private User u;
	private Room room;
	
	public UserStateInfo(User u) {
		this.u = u;
	}
	
	public User getU() {
		return u;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
}
