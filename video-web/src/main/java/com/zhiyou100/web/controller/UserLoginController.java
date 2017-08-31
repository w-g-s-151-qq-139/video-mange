package com.zhiyou100.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.dao.model.User;
import com.zhiyou100.service.user.UserService;
import com.zhiyou100.web.util.MD5Util;


@Controller
public class UserLoginController {

	@Autowired
	UserService us;
	
	@RequestMapping("/user/index.action")
	public String index(){
		return "/qiantai/index";
	}
	@RequestMapping("/user/logout.action")
	public String logout(HttpSession req){
		req.removeAttribute("_front_user");
		return "/qiantai/index";
	}
	
	
	
	//ajax
	@RequestMapping("/user/userlogin.action")
	@ResponseBody
	public String Userlogin(User u,HttpSession req){
		u.setPassword(MD5Util.MD5EncodeUtf8(u.getPassword()));
		List<User> ul=us.login(u);
		
		if(ul.size()!=0){
			req.setAttribute("_front_user", ul.get(0));
			return "true";
		}else{
			return "false";
		}
	}
	//ajax
	@RequestMapping("/user/regist.action")
	@ResponseBody
	public String Userregist(User u,HttpServletRequest req){
		u.setPassword(MD5Util.MD5EncodeUtf8(u.getPassword()));
		List<User> ul=us.select(u);
		if(ul.size()!=0){
			return "false";
		}else{
			us.register(u);
			return "true";
		}
	}
	
}
