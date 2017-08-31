package com.zhiyou100.web.controller.user;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.dao.model.User;
import com.zhiyou100.service.user.UserService;
import com.zhiyou100.web.util.MD5Util;
import com.zhiyou100.web.util.MailUtil;
import com.zhiyou100.web.util.Verification;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	UserService us;

	String verificationCode;
	/*
	 * 个人资料
	 */
	@RequestMapping(value="/userdata.action")
	public String userindex(HttpServletRequest req,Model m) throws Exception {
		User u=(User)req.getSession().getAttribute("_front_user");
		u=us.select(u).get(0);
		req.getSession().setAttribute("_front_user", u);
		m.addAttribute("user", u);
		
		return "/user/index";
	}

	/*
	 * 修改资料
	 */
	@RequestMapping(value="/keepprofile.action")
	public String keepprofile(User u,String birthday1,  HttpServletRequest req) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(birthday1);
		u.setBirthday(date);
		
		u.setId(((User)req.getSession().getAttribute("_front_user")).getId());
		us.update(u);
		
		
		return "redirect:/user/userdata.action";
	}
	
	/*
	 * 外部忘记密码
	 */
	@RequestMapping("/forget_pwd.action")
	public String forget_pwd() {
		return "/user/forget_pwd";
	}

	
	
	// ajax
	@RequestMapping("/sendmail.action")
	@ResponseBody
	public String sendmail(String email,HttpServletRequest req) throws Exception {
		verificationCode=Verification.verification();
		req.getSession().setAttribute("email", email);
		MailUtil.send(email, "密码更改验证", "您正在进行更改密码操作,如非本人操作,请忽略本消息.验证码:"+verificationCode+
				". <a href='http://localhost:8080/video-web/user/forget_pwd.action'>重置密码</a>");
		return "true";
	}
	//ajax
	@RequestMapping("/forgetpwd.action")
	@ResponseBody
	public String forgetpwd(String captcha) {
		if(verificationCode.equals(captcha)){
			return "true";
		}else
		return "false";	
	}
	/*
	 * 外部重置密码
	 */
	@RequestMapping("/reset_pwd.action")
	public String reset_pwd() {
		return "/user/reset_pwd";
	}
	//ajax
	@RequestMapping("/resetpwd.action")
	public String resetpwd(User u) {
		u.setPassword(MD5Util.MD5EncodeUtf8(u.getPassword()));
		us.update(u);
		return "redirect:/user/index.action";
	}
	
	
	/*
	 * 资料
	 */
	@RequestMapping("/profile.action")
	public String profile(HttpServletRequest req,Model m) {
		User u = (User) req.getSession().getAttribute("_front_user");
		List<User> ul = us.select(u);
		
		m.addAttribute("user",ul.get(0));
		return "/user/profile";
	}

	
	/*
	 * 头像
	 */
	@RequestMapping("/avatar.action")
	public String avatar(Model m) {
		
		return "/user/avatar";
	}
	@RequestMapping("/altavatar.action")
	public String altavatar(MultipartFile image_file,HttpServletRequest req) throws Exception{
		if(image_file.getOriginalFilename()==""){
			return "/user/avatar";
		}
		 String str = UUID.randomUUID().toString().replaceAll("-", "");
		 String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		 String fileName = str+"."+ext;
		 User u = (User) req.getSession().getAttribute("_front_user");
		 u.setHeadUrl(fileName);
		 us.update(u);
		 //需要得到绝对路径相对于磁盘的路径
		 //我们现在知道相对web的应用的路径/upload
		 //需要用到servletContext
		 //String path = req.getServletContext().getRealPath("/upload");
		  String path = "D:\\upload";
		 //System.out.println(path);
		  image_file.transferTo(new File(path+"\\"+fileName));	 
		
		return "redirect:/user/userdata.action";
	}
	/*
	 * 内部密码
	 */

	@RequestMapping("/password.action")
	public String password() {
		
		return "/user/password";
	}
	
	
	
	
	//ajax
	@RequestMapping("/altpassword.action")
	@ResponseBody
	public String password(String oldPassword,String newPassword,HttpServletRequest req) {
		User u = (User) req.getSession().getAttribute("_front_user");
		oldPassword=MD5Util.MD5EncodeUtf8(oldPassword);
		if(oldPassword.equals(u.getPassword())){
			u.setPassword(MD5Util.MD5EncodeUtf8(newPassword));
			us.update(u);
			return "true";
		}else{
			return "false";
		}	
	}
}
