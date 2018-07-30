package com.wen.crud.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wen.crud.user.entity.User;
@Mapper
public interface UserMapper {
		@Select("select * from smbms_user where userCode LIKE '%${id}%' limit #{startIndex},#{limit}")
		public List<User> limit(@Param("startIndex") Integer startIndex,@Param("limit") Integer limit,@Param("id") String id);
		@Select("select count(*) from smbms_user")
		public int queryAll();
		@Select("select * from smbms_user where userCode = #{userCode} and userPassword = #{userPassword}")
		public User queryUserByup(User user);
		@Insert("INSERT INTO smbms_user(userCode,userName,birthday,phone,address,gender) VALUE(#{userCode},#{userName},#{birthday},#{phone},#{address},#{gender})")
		public int insertAll(User user);
		@Delete("DELETE FROM `smbms_user` WHERE id IN (${userIds})")
		public int deleyeUserById(@Param("userIds") String userIds);
		@Update("UPDATE smbms_user SET userCode=#{userCode}, userName=#{userName}, gender=#{gender}, birthday=#{birthday}, phone=#{phone}, address=#{address}, userRole=#{userRole} WHERE (id=#{id})")
		public int updateUser(User user);
		@Update("UPDATE smbms_user SET ${value} WHERE (id=#{id})")
		public int updateUserByName(@Param("value") String value,@Param("id") int id);
}
