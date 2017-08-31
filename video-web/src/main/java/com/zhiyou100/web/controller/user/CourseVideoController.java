package com.zhiyou100.web.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.dao.model.Course;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.Subject;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.service.course.CourseService;
import com.zhiyou100.service.lecturer.LecturerService;
import com.zhiyou100.service.subject.SubjectService;
import com.zhiyou100.service.video.VideoService;

@Controller
public class CourseVideoController {

	@Autowired
	CourseService cs;
	@Autowired
	SubjectService ss;
	@Autowired
	VideoService vs;
	@Autowired
	LecturerService ls;
	@RequestMapping("/course/index.action")
	public String courseindex(Integer subjectId,Model m){
		List<Course> courses=cs.courseshow(subjectId);
		Subject subject=ss.selectbyid(subjectId);
		m.addAttribute("courses", courses);
		m.addAttribute("subjectId", subjectId);
		m.addAttribute("subject", subject);
		return "/course/index";
	}
	
	@RequestMapping("/video/index.action")
	public String videoindex(Integer subjectId,Integer videoId,Model m){
		Subject subject=ss.selectbyid(subjectId);
		m.addAttribute("subject", subject);
		Video video=vs.findone(videoId);
		m.addAttribute("videoId", videoId);
		m.addAttribute("video", video);
		return "/video/index";
	}
	
	@RequestMapping("/video/state.action")
	public void videostate(Integer videoId){
		Video video=vs.findone(videoId);
		video.setVideoPlayTimes(video.getVideoPlayTimes()+1);
		vs.updatevideo(video);
	}
	
	@RequestMapping("/video/videoData.action")
	public String videodata(Integer videoId,Model m){
		Video video=vs.findone(videoId);
		m.addAttribute("video", video);
		
		Speaker speaker=ls.findone(video.getSpeakerId());
		m.addAttribute("speaker", speaker);
		
		Course course =cs.findone(video.getCourseId());
		m.addAttribute("course", course);
		
		List<Course> courses=cs.courseshow(course.getSubjectId());
		List<Video> videolist=course.getVideolist();
		for(Course c:courses){
			
			videolist.addAll(c.getVideolist());
		}
		videolist.remove(0);
		List<Speaker> sp=ls.findall();
		
		m.addAttribute("speakerlist", sp);
		m.addAttribute("videolist", videolist);
		return "/video/content";
	}
}
