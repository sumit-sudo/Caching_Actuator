package com.chache.security.h2.acuator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chache.security.h2.acuator.dao.UserRepo;
import com.chache.security.h2.acuator.entity.User;

@Service
public class UserService {

	
	@Autowired
	UserRepo repo;
	public User saveUser(User user)
	{
		User save;
		try {
		save= repo.save(user);
		
		}catch (Exception e) {
			return null;
		}
		return save; 
	}
}
