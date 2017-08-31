package com.zhiyou100.service.impl.lecturer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.mapper.SpeakerMapper;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.SearchSpeaker;
import com.zhiyou100.service.lecturer.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Autowired
	SpeakerMapper sm;
	@Override
	public List<Speaker> findall() {
		return sm.selectByExample(null);
	}
	@Override
	public List<Speaker> findall(String searchspeakerName, String searchspeakerJob, int page) {
		SearchSpeaker speaker=new SearchSpeaker(searchspeakerName, searchspeakerJob, (page-1)*10);
		return sm.findall(speaker);
	}
	@Override
	public int count(String searchspeakerName, String searchspeakerJob) {
		SearchSpeaker speaker=new SearchSpeaker(searchspeakerName, searchspeakerJob,0);
		return sm.count(speaker);
	}
	@Override
	public void delvideo(Integer id) {
		// TODO Auto-generated method stub
		sm.deleteByPrimaryKey(id);
	}
	@Override
	public Speaker findone(Integer id) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(id);
	}
	
	@Override
	public void updatespeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		sm.updateByPrimaryKeySelective(speaker);
	}
	@Override
	public void addspeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		sm.insertSelective(speaker);
	}

}
