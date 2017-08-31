package com.zhiyou100.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.dao.mapper.SpeakerMapper;
import com.zhiyou100.dao.model.Admin;
import com.zhiyou100.dao.model.Course;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.VideoWarp;
import com.zhiyou100.service.LoginService;
import com.zhiyou100.service.course.CourseService;
import com.zhiyou100.service.lecturer.LecturerService;
import com.zhiyou100.service.video.VideoService;
import com.zhiyou100.web.util.MD5Util;

@Controller
public class LoginController {

	@Autowired
	LoginService ls;
	@Autowired
	LecturerService lts;
	@Autowired
	CourseService cs;

	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(Admin obj, HttpServletRequest req) {
//		if (obj.getLoginPwd() == null) {
//			req.setAttribute("loginName", obj.getLoginName());
//			req.setAttribute("error", "’À∫≈≤ªƒ‹Œ™ø’");
//			return "redirect:/index.jsp";
//		}
		obj.setLoginPwd(MD5Util.MD5EncodeUtf8(obj.getLoginPwd()));
		List<Speaker> speakerlist = lts.findall();
		List<Course> courselist = cs.findall();
		List<Admin> adminlist = ls.login(obj);
		String str = "forward:/houtai/index.jsp";
		if (adminlist.size() != 0) {
			str = "forward:/admin/search.action";
			req.getSession().setAttribute("admin", adminlist.get(0));
			req.getSession().setAttribute("speakerlist", speakerlist);
			req.getSession().setAttribute("courselist", courselist);
		}
		req.setAttribute("loginName", obj.getLoginName());
		req.setAttribute("error", "’À∫≈∫Õ√‹¬Î≤ª∆•≈‰");
		return str;
	}

	@RequestMapping(value = "/show.action")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		List<VideoWarp> videolist = ls.show();
		mv.addObject("videolist", videolist);
		mv.setViewName("/video/video");
		return mv;
	}
}
