package com.wen.crud.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.wen.crud.user.entity.User;
@Service
public interface UserService {
	public List<User> limit(@Param("startIndex") Integer startIndex,@Param("limit") Integer limit,@Param("id") String id);
	public int queryAll();
	public int insertAll(User user);
	public int deleyeUserById(String userIds);
	public int updateUser(User user);
	public int updateUserByName(String value,int id);
	public User queryUserByup(User user);
	
}
