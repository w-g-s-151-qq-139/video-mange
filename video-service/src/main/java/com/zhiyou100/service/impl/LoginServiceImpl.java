package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.zhiyou100.dao.mapper.AdminMapper;
import com.zhiyou100.dao.mapper.UserMapper;
import com.zhiyou100.dao.mapper.VideoMapper;
import com.zhiyou100.dao.model.Admin;
import com.zhiyou100.dao.model.AdminExample;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.VideoWarp;
import com.zhiyou100.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	AdminMapper lm;
	@Autowired
	VideoMapper vm;
	@Override
	public List<Admin> login(Admin obj) {
		AdminExample example=new AdminExample();
		example.createCriteria().andLoginNameEqualTo(obj.getLoginName()).andLoginPwdEqualTo(obj.getLoginPwd());
		return lm.selectByExample(example);
	}
	@Override
	public List<VideoWarp> show() {
		return vm.show();
	}

}
