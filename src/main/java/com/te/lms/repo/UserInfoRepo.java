package com.te.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.pojo.UserInfo;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>{
	public UserInfo findByUsername(String username);
}
