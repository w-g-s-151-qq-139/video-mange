package com.zhiyou100.service.impl.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.mapper.VideoMapper;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.CourseWarp;
import com.zhiyou100.dao.warp.SearchVideo;
import com.zhiyou100.dao.warp.VideoWarp;
import com.zhiyou100.service.video.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoMapper vm;
	@Override
	public void delvideo(Integer id) {
		// TODO Auto-generated method stub
		vm.deleteByPrimaryKey(id);
	}
	@Override
	public Video findone(Integer id) {
		// TODO Auto-generated method stub
		return vm.selectByPrimaryKey(id);
	}
	@Override
	public List<VideoWarp> findterm(String searchvideoTitle, String searchcourseId, String searchspeakerId,
			Integer currentpage) {
		
		SearchVideo sv=new SearchVideo();
		sv.setCourseid(searchcourseId);
		sv.setCurrentpage((currentpage-1)*10);
		sv.setSpeakerid(searchspeakerId);
		sv.setTitle(searchvideoTitle);
		return vm.findterm(sv);
	}
	@Override
	public int count(String searchvideoTitle, String searchcourseId, String searchspeakerId, Integer currentpage) {
		SearchVideo sv=new SearchVideo();
		sv.setCourseid(searchcourseId);
		sv.setCurrentpage((currentpage-1)*10);
		sv.setSpeakerid(searchspeakerId);
		sv.setTitle(searchvideoTitle);
		return vm.count(sv);
	}
	@Override
	public int addvideo(Video video) {
		
		return vm.insertSelective(video);
	}
	@Override
	public int updatevideo(Video video) {
		return vm.updateByPrimaryKeySelective(video);
	}
	@Override
	public void batch(String id) {
		vm.batch(id);
	}
	@Override
	public List<CourseWarp> avgtimes() {
		return vm.avgcourse();
	}
	
}
