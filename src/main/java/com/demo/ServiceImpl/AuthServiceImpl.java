package com.demo.ServiceImpl;

import java.util.ArrayList;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.service.AuthInterface;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service("authServiceImpl")
public class AuthServiceImpl implements AuthInterface{


	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUserName(String email) throws UsernameNotFoundException {
		User user;
		user=userRepository.findByEmail(email);
		if(user == null) {

			throw new UsernameNotFoundException("User not found with Email: " + email);

		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
	}


	@Override
	public boolean comaprePassword(String Password, String hashPassword) 
	{
		return bcryptEncoder.matches(Password, hashPassword);
	}



}
