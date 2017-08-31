package com.zhiyou100.web.controller.course;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.dao.mapper.SubjectMapper;
import com.zhiyou100.dao.model.Course;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.Subject;
import com.zhiyou100.service.course.CourseService;
import com.zhiyou100.web.util.Page;

@Controller
public class CourseController {

	@Autowired
	CourseService cs;
	@Autowired
	SubjectMapper sm;
	
	@RequestMapping("/admin/searchcourse.action")
	public ModelAndView search(@RequestParam(defaultValue="") String courseName,
			Page<Course> page,HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		List<Course> courselist = null;
		page.setPage(page.getPage()==0?1:page.getPage());
		int count=cs.count();
		List<Subject> subject = sm.selectByExample(null);
		req.getSession().setAttribute("subject", subject);
		courselist=cs.findall(page.getPage());
		req.getSession().setAttribute("courselist", courselist);
		page.setSize(10);
		page.setRows(courselist);
		page.setTotal(count);
		mv.addObject("page", page);
		mv.setViewName("/course/course");
		return mv;
	}
	
	@RequestMapping("/admin/delcourse.action")
	public String delcourse(Integer id) {
		System.out.println(id);
		cs.delcourse(id);
		return "forward:/admin/searchcourse.action";
	}
	
	@RequestMapping("/admin/altcourse.action")
	public ModelAndView altvideo(Integer id) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("editcourse", cs.findone(id));
		mv.setViewName("/course/addcourse");
		return mv;
	}
	
	@RequestMapping(value="/admin/addcourse.action",method=RequestMethod.POST)
	public ModelAndView addvideo(Course course) {
		ModelAndView mv = new ModelAndView();
		if(course.getId()!=null){
			cs.updatespeaker(course);
		}else{
			cs.addspeaker(course);
		}
		mv.setViewName("forward:/admin/searchcourse.action");
		return mv;
	}
}
