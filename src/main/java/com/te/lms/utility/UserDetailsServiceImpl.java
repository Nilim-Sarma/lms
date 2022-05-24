package com.te.lms.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.lms.customexcpetion.UserNotFoundExcpertion;
import com.te.lms.dto.MyUserDetails;
import com.te.lms.pojo.User;
import com.te.lms.repo.UserInfoRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserInfoRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUserName(username);
		log.info(username);
//		if (user == null) {
//			throw new UserNotFoundExcpertion("No user found with username : " + username);
//		}
		return new MyUserDetails(user);
	}

}
