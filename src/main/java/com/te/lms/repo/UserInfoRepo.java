package com.te.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.pojo.User;


public interface UserInfoRepo extends JpaRepository<User, Integer>{
	
	public User findByUserName(String username);
}
