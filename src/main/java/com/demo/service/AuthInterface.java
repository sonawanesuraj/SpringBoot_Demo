package com.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthInterface {
	public UserDetails loadUserByUserName(String email)throws UsernameNotFoundException;
	
	public boolean comaprePassword(String Password , String hashPassword);

}
