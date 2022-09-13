package com.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan("com.demo")
@ComponentScan("com.demo")
public class SpringBootDemoApplication{


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);			
	} 
	

	@Bean
	public ModelMapper modelMaper() {
		
		return new ModelMapper();
		
	}


}  


