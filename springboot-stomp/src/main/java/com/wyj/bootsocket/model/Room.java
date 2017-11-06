package com.wyj.bootsocket.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author wuyingjie
 * @date 2017年11月6日
 */

public class Room {
	private String id;
	
	private User owner;
	
//	private int size;
	
	public Room() {}
	
	public Room(String id, User owner) {
		this.id = id;
		this.owner = owner;
//		size = 2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
	
	private static Map<String, Room> roomCache = Collections.synchronizedMap(new HashMap<>());
	
	public static void add(Room room) {
		roomCache.put(room.getId(), room);
	}
	
	public static Room get(String roomId) {
		return roomCache.get(roomId);
	}
	
	public static Room remove(String roomId) {
		return roomCache.remove(roomId);
	}
}
