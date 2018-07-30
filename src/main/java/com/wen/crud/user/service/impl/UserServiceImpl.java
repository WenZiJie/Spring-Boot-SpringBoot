package com.wen.crud.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wen.crud.user.entity.User;
import com.wen.crud.user.mapper.UserMapper;
import com.wen.crud.user.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	public List<User> limit(Integer page, Integer limit, String id) {
		int startIndex = (page-1)*limit;
		return userMapper.limit(startIndex,limit,id);
	}

	public int queryAll() {
		return userMapper.queryAll();
	}

	public int insertAll(User user) {
		return userMapper.insertAll(user);
	}

	public int deleyeUserById(String userIds) {
		return userMapper.deleyeUserById(userIds);
	}

	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	public int updateUserByName(String value,int id) {
		return userMapper.updateUserByName(value,id);
	}

	public User queryUserByup(User user) {
		return userMapper.queryUserByup(user);
	}

}
