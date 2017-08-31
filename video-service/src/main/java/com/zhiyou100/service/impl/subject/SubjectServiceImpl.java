package com.zhiyou100.service.impl.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.mapper.SubjectMapper;
import com.zhiyou100.dao.model.Subject;
import com.zhiyou100.service.subject.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectMapper sm;
	@Override
	public Subject selectbyid(Integer subjectId) {
		
		return sm.selectByPrimaryKey(subjectId);
	}

}
