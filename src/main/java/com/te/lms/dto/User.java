//package com.te.lms.dto;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.te.lms.pojo.UserInfo;
//
//@SuppressWarnings("serial")
//public class User implements UserDetails{
//
//	private String username;
//	private String password;
//	private List<GrantedAuthority> authorities;
//	
//	
//	
//	public User(UserInfo user) {
//		this.username = user.getUsername();
//		this.password = user.getPassword();
//		this.authorities = Arrays.stream(user.getAuthorities().split(","))
//				.map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toList());
//		System.out.println("from user ===========>" +this.username);
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		return username;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//}
