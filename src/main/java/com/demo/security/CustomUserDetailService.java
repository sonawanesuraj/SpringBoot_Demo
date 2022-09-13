package com.demo.security;


import java.util.ArrayList;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
	User user =userRepository.findByEmail(username);
	
	if(user==null) {
		throw new UsernameNotFoundException("User Not Found ");
	}
	
//return new org.springframework.security.core.userdetails.UserDetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
	
	return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
	
	
	}
	

	
	
	
	
	
}
