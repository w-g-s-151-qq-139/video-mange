package com.zhiyou100.web.controller.video;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.VideoWarp;
import com.zhiyou100.service.video.VideoService;
import com.zhiyou100.web.util.Page;

@Controller
public class VideoController {

	@Autowired
	VideoService vs;

	@RequestMapping("/admin/delvideo.action")
	public String delvideo(int id) {
		vs.delvideo(id);
		return "forward:/admin/search.action";
	}
	@RequestMapping("/admin/batchvideo.action")
	public String batchvideo(String id) {
		vs.batch(id);
		return "redirect:/admin/search.action";
	}

	@RequestMapping("/admin/altvideo.action")
	public ModelAndView altvideo(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("editvideo", vs.findone(id));
		mv.setViewName("/video/addvideo");
		return mv;
	}

	@RequestMapping(value="/admin/addvideo.action",method=RequestMethod.POST)
	public ModelAndView addvideo(Video video) {
		ModelAndView mv = new ModelAndView();
		if(video.getId()!=null){
			vs.updatevideo(video);
		}else{
			vs.addvideo(video);
		}
		mv.setViewName("redirect:/admin/search.action");
		return mv;
	}

	@RequestMapping("/admin/search.action")
	public ModelAndView search(@RequestParam(defaultValue="") String searchvideoTitle,
			@RequestParam(defaultValue="") String searchcourseId,
			@RequestParam(defaultValue="") String searchspeakerId,Page<VideoWarp> page) {
		ModelAndView mv = new ModelAndView();
		List<VideoWarp> videolist = null;
		page.setPage(page.getPage()==0?1:page.getPage());
		int count=vs.count(searchvideoTitle, searchcourseId, searchspeakerId, page.getPage());
		
		videolist=vs.findterm(searchvideoTitle,searchcourseId,searchspeakerId,page.getPage());
		page.setSize(10);
		page.setRows(videolist);
		page.setTotal(count); 
		mv.addObject("searchvideoTitle", searchvideoTitle);
		mv.addObject("searchcourseId", searchcourseId);
		mv.addObject("searchspeakerId", searchspeakerId);
		mv.addObject("page", page);
		mv.setViewName("/video/video");
		return mv;
	}
}
