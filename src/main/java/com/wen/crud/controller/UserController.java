package com.wen.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wen.crud.result.Result;
import com.wen.crud.user.entity.User;
import com.wen.crud.user.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private  UserService us;

    @PostMapping("/login")
    User queryByup(@RequestBody User user) throws InterruptedException {
    	User ruser = us.queryUserByup(user);
    	return ruser;
    }
    
    @GetMapping("/")
    Result limit(int page,int limit,String id) {
    	if (id==null) id="";
    	List<User> userlist = us.limit(page, limit,id);
    	Result result = new Result(0, "", us.queryAll(), userlist);
        return result;
    }
    
    @PostMapping("/")
    Result addUser(@RequestBody User user) {
    	if(us.insertAll(user) > 0)
    	return new Result(1,"添加成功!", 0, null);
    	
    	return new Result(0,"添加失败!", 0, null);
    }
    
    @DeleteMapping("/{deleteIds}")
    Result deleteUser(@PathVariable String deleteIds) {
    	if(us.deleyeUserById(deleteIds) > 0)
    	return new Result(1, "删除成功!", 0, null);
    	
    	return new Result(0, "删除失败!", 0, null);
    }
    
    @PutMapping("/{id}")
    Result updateUser(@RequestBody User user,@PathVariable int id) {
    	user.setId(id);
    	if(us.updateUser(user) > 0)
    	return new Result(1, "修改成功!", 0, null);
    	
    	return new Result(0, "修改失败!", 0, null);
    }
    
    
    @PutMapping("/{id}/{field}")
    Result updateUserByName(@PathVariable int id,@PathVariable String field,String value) {
    	if(us.updateUserByName(field+"='"+value+"'",id) > 0)
    	return new Result(1, "修改成功!", 0, null);
    	
    	return new Result(0, "修改失败!", 0, null);	
    }
    
}
