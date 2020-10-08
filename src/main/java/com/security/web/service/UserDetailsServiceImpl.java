package com.security.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.security.web.MyUserDetails;
import com.security.web.UserRepository;
import com.security.web.entity.Users;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=repository.getUserByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User name not found");
		}
		return new MyUserDetails(user);
	}

}
