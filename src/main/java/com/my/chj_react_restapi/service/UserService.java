package com.my.chj_react_restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.chj_react_restapi.dao.UserDao;
import com.my.chj_react_restapi.vo.User;

@Service
public class UserService {

	
	@Autowired
	UserDao userDao;
	
	
	public int save(User u) {
		return userDao.save(u);
	}
	
	public List<User> all() {
		return userDao.all();
	}
	
}
