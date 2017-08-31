package com.zhiyou100.web.controller.lecturer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.service.lecturer.LecturerService;
import com.zhiyou100.web.util.Page;

@Controller
public class LecturerController {

	@Autowired
	LecturerService ls;
	
	@RequestMapping("/admin/searchspeaker.action")
	public ModelAndView search(@RequestParam(defaultValue="") String searchspeakerName,
			@RequestParam(defaultValue="") String searchspeakerJob,
			Page<Speaker> page,HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		List<Speaker> speakerlist = null;
		page.setPage(page.getPage()==0?1:page.getPage());
		int count=ls.count(searchspeakerName, searchspeakerJob);
		
		speakerlist=ls.findall(searchspeakerName,searchspeakerJob,page.getPage());
		req.getSession().setAttribute("speakerlist", speakerlist);
		page.setSize(10);
		page.setRows(speakerlist);
		page.setTotal(count);
		mv.addObject("searchspeakerName", searchspeakerName);
		mv.addObject("searchspeakerJob", searchspeakerJob);
		mv.addObject("page", page);
		mv.setViewName("lecturer/lecturer");
		return mv;
	}
	
	@RequestMapping("/admin/delspeaker.action")
	public String delvideo(Integer id) {
		System.out.println(id);
		ls.delvideo(id);
		return "forward:/admin/searchspeaker.action";
	}
	
	@RequestMapping("/admin/altspeaker.action")
	public ModelAndView altvideo(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("editspeaker", ls.findone(id));
		mv.setViewName("/lecturer/addlecturer");
		return mv;
	}
	
	@RequestMapping(value="/admin/addspeaker.action",method=RequestMethod.POST)
	public ModelAndView addvideo(Speaker speaker) {
		ModelAndView mv = new ModelAndView();
		if(speaker.getId()!=null){
			ls.updatespeaker(speaker);
		}else{
			ls.addspeaker(speaker);
		}
		mv.setViewName("forward:/admin/searchspeaker.action");
		return mv;
	}
}
