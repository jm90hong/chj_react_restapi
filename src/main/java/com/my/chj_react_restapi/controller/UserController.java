package com.my.chj_react_restapi.controller;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.chj_react_restapi.service.UserService;
import com.my.chj_react_restapi.vo.User;

@CrossOrigin("*")
@RestController
@RequestMapping(value="api/user")
public class UserController {

	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/save")
	public String save(
				@RequestParam(value="f") String first_name,
				@RequestParam(value="l",defaultValue = "") String last_name,
				@RequestParam(value="g") String gender,
				@RequestParam(value="tel") String tel,
				@RequestParam(value="id") String id,
				@RequestParam(value="pw") String pw,
				@RequestParam(value="b") String birth,
				@RequestParam(value="nick",defaultValue = "") String nick
			) {
		
		
		String code = RandomStringUtils.randomAlphanumeric(10);
		
		
		
		User user =  new User();
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setUser_code(code);
		user.setGender(gender);
		user.setTel(tel);
		user.setId(id);
		user.setPw(pw);
		user.setBirth(birth);
		user.setNick(nick);
		
		userService.save(user);
		
		
		return "ok";
	}
	
	
	@GetMapping("/all")
	public List<User> all() {
		
		return userService.all();
	}
}
