package com.yulu.mangger.service;

import com.yulu.mangger.bean.User;
/**   
 * @Description: 服务层接口
 */
public interface HrmService {


	/**
	 * 用户登录
	 * @param  loginname
	 * @param  password
	 * @return User对象
	 * */
	User login(String loginname, String password);
	
	
}
