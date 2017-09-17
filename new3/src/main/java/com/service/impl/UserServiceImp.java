package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;

public class UserServiceImp implements UserService {
	// 注入User
	@Autowired
	private UserMapper usermapper;

	@Override
	public List<User> findUserList(User user) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.findUserList(user);
	}

	@Override
	public User findUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return usermapper.selectByPrimaryKey(id);
	}

	@Override
	public void edit_do(User user) throws Exception {
		// TODO Auto-generated method stub
		usermapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void delete_do(Integer id) throws Exception {
		// TODO Auto-generated method stub
		usermapper.deleteByPrimaryKey(id);
	}

	@Override
	public void add_do(User user) throws Exception {
		// TODO Auto-generated method stub
		usermapper.insertSelective(user);
	}

	@Override
	public User findLoginUser(String username, String password)
			throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return usermapper.findLoginUser(user);
	}

	@Override
	public void ban_do(Integer id) throws Exception {
		User user = new User();
		user.setId(id);
		user.setIsdelete(1);
		usermapper.banById(user);
	}

	@Override
	public void ok_do(Integer id) throws Exception {
		User user = new User();
		user.setId(id);
		user.setIsdelete(0);
		usermapper.okById(user);
	}
}
