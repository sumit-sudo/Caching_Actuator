package com.chache.security.h2.acuator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chache.security.h2.acuator.entity.User;
import com.chache.security.h2.acuator.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService service;
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user)
	{
		System.out.println(user.getUser_name());
		User saveUser = service.saveUser(user);
		return saveUser;
	}
}
