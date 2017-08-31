package com.zhiyou100.service.impl.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.mapper.CourseMapper;
import com.zhiyou100.dao.model.Course;
import com.zhiyou100.service.course.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper cm;
	
	@Override
	public List<Course> findall() {
		// TODO Auto-generated method stub
		return cm.selectByExample(null);
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return cm.countByExample(null);
	}
	@Override
	public List<Course> findall(int page) {
		// TODO Auto-generated method stub
		
		return cm.findall((page-1)*10);
	}
	@Override
	public void delcourse(Integer id) {
		// TODO Auto-generated method stub
		cm.deleteByPrimaryKey(id);
	}
	@Override
	public Course findone(Integer id) {
		// TODO Auto-generated method stub
		return cm.selectByPrimaryKey(id);
	}
	@Override
	public void updatespeaker(Course course) {
		// TODO Auto-generated method stub
		cm.updateByPrimaryKeySelective(course);
	}
	@Override
	public void addspeaker(Course course) {
		// TODO Auto-generated method stub
		cm.insertSelective(course);
	}
	@Override
	public List<Course> courseshow(Integer subjectId) {
		// TODO Auto-generated method stub
		return cm.courseshow(subjectId);
	}

}
