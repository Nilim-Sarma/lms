package com.te.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.pojo.MyUserDetails;

@Repository
public interface UserInfoRepo extends JpaRepository<MyUserDetails, Integer>{
	public MyUserDetails findByUsername(String username);
}
