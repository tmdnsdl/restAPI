package com.tmdnsdl.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmdnsdl.rest.mapper.UserMapper;
import com.tmdnsdl.rest.model.UserInfo;

@RestController
public class UserController {
	
	private final UserMapper mapper;
	
	public UserController(UserMapper mapper) {
		this.mapper = mapper;
	}
	
   @GetMapping("/user/all")
   public List<UserInfo> getUserInfoList(HttpServletResponse response) {
      response.setHeader("Access-Control-Allow-Origin", "*");
      return mapper.getUserInfoList();
   }
   
   @GetMapping("/user/{user_id}")
   public UserInfo getUserInfo(HttpServletResponse response, @PathVariable("user_id") String user_id) {
      response.setHeader("Access-Control-Allow-Origin", "*");
      return mapper.getUserInfo(user_id);
   }
   
   @PostMapping("/user/insertUser")
   public int postUserInfo(HttpServletResponse response, UserInfo user) {
	   response.setHeader("Access-Control-Allow-Origin", "*");
	   user.setUser_createdate("2022-03-28");
	   user.setUser_ranknum(1);
	   user.setUser_grant("일반 사용자");
	   user.setUser_menu_id("");
	   return mapper.insertUserInfo(user);
   }
   
   @PutMapping("/user/updateUser")
   public int putUserInfo(HttpServletResponse response, UserInfo user) {
	   response.setHeader("Access-Control-Allow-Origin", "*");
	   user.setUser_updatedate("2022-03-29");
	   user.setUser_ranknum(1);
	   user.setUser_grant("일반 사용자");
	   return mapper.updateUserInfo(user);
   }
   
   @DeleteMapping("/user/{user_id}")
   public int deleteUserInfo(HttpServletResponse response, @PathVariable("user_id") String user_id) {
	   response.setHeader("Access-Control-Allow-Origin", "*");
	   return mapper.deleteUserInfo(user_id);
   }
}
