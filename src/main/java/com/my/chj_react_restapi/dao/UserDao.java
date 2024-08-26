package com.my.chj_react_restapi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.chj_react_restapi.vo.User;

@Repository
public class UserDao {
	
	
	@Autowired
	SqlSession s;
	
	
	public int save(User u) {
		return s.insert("UserMapper.save",u);
	}
	
	public List<User> all() {
		return s.selectList("UserMapper.findAll");
	}
}
