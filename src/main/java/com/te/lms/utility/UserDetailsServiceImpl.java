//package com.te.lms.utility;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.te.lms.customexcpetion.UserNotFoundExcpertion;
//import com.te.lms.dto.User;
//import com.te.lms.pojo.UserInfo;
//import com.te.lms.repo.UserInfoRepo;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService{
//
//	@Autowired
//	private UserInfoRepo repo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserInfo user = repo.findByUsername(username);
//		if(user == null) {
//			throw new UserNotFoundExcpertion("No user found with username : "+username);
//		}
//		return new User(user);
//	}
//
//}
