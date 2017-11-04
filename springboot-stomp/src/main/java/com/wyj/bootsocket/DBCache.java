package com.wyj.bootsocket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.wyj.bootsocket.model.User;

/**
 * 
 * @author wuyingjie
 * @date 2017年10月31日
 */

public class DBCache {
	
	private static final Map<String, User> cache = Collections.synchronizedMap(new HashMap<>());
	
	static {
		User u = null;
		u = new User("小明", "123456");
		cache.put(u.getName(), u);
		u = new User("小芳", "123456");
		cache.put(u.getName(), u);
		u = new User("Tom", "111111");
		cache.put(u.getName(), u);
		u = new User("Jerry", "111111");
		cache.put(u.getName(), u);
	}
	
	public static boolean isExist(String un, String pswd) {
		User user = cache.get(un);
		if (user != null && !StringUtils.isEmpty(pswd)) {
			return user.getPswd().equals(pswd);
		}
		return false;
	}

}
