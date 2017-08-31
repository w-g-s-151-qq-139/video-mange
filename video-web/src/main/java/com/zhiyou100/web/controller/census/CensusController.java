package com.zhiyou100.web.controller.census;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.dao.warp.CourseWarp;
import com.zhiyou100.service.video.VideoService;

@Controller
public class CensusController {

	@Autowired
	VideoService vs;

	@RequestMapping("/census.action")
	public String show(Model m) {
		List<CourseWarp> census = vs.avgtimes();

		String avgtimes = "";
		String coursename = "";
		for (CourseWarp c : census) {
			coursename += c.getCourseName() + ",";
			if (c.getAvgtimes() == null) {
				avgtimes += "0,";
			} else
				avgtimes += c.getAvgtimes() + ",";
		}
		// String[] name=coursename.split(",");

		m.addAttribute("coursename", coursename);
		m.addAttribute("avgtimes", avgtimes);
		return "/census/census";
	}
}
