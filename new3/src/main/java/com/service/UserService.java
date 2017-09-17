package com.service;

import java.util.List;

import com.entity.User;

/**
 * @ClassName: UserService.java
 * @author zhangwei
 * @E-mail:1505522625@qq.com
 * @time 2016�?�?�?上午10:42:16
 * @version v1.0
 * @Description:TODO
 */

public interface UserService {
	public List<User> findUserList(User user) throws Exception;

	public User findUserById(Integer id) throws Exception;

	public void edit_do(User user) throws Exception;

	public void delete_do(Integer id) throws Exception;

	public void ban_do(Integer id) throws Exception;

	public void ok_do(Integer id) throws Exception;

	public void add_do(User user) throws Exception;

	public User findLoginUser(String username, String password)
			throws Exception;

}
