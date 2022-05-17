package com.chache.security.h2.acuator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chache.security.h2.acuator.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
