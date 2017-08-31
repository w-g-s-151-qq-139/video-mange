package com.zhiyou100.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.mapper.UserMapper;
import com.zhiyou100.dao.model.User;
import com.zhiyou100.dao.model.UserExample;
import com.zhiyou100.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper um;
	@Override
	public List<User> login(User u) {
		// TODO Auto-generated method stub
		UserExample ue=new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andPasswordEqualTo(u.getPassword());
		return um.selectByExample(ue);
	}
	@Override
	public int register(User u) {
		// TODO Auto-generated method stub
		return um.insertSelective(u);
	}
	@Override
	public List<User> select(User u) {
		UserExample ue=new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail());
		return um.selectByExample(ue);
	}
	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		UserExample ue=new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail());
		u.setId(um.selectByExample(ue).get(0).getId());
		um.updateByPrimaryKeySelective(u);
	}

}
