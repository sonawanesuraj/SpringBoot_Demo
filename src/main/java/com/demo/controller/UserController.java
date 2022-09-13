package com.demo.controller;

import javax.validation.Valid;

import com.demo.dto.UserDto;
import com.demo.entity.User;
import com.demo.exception.ErrorResponceDto;
import com.demo.exception.Message;
import com.demo.exception.ResourceNotFoundException;
import com.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
     private UserService userService;

	// add users data
//	@PostMapping("/user")
//	public ResponseEntity<?> addUserdata(@Valid @RequestBody UserDto userDto) {
//
//		try {
//			UserDto createUserDto = this.userService.createUser(userDto);
//			return new ResponseEntity<>(new Message("Success", "Success", createUserDto), HttpStatus.CREATED);
//		} catch (ResourceNotFoundException e) {
//			return new ResponseEntity<>(new ErrorResponceDto(e.getMessage(), "Access Denied"), HttpStatus.BAD_GATEWAY);
//
//		}

	

	// get all user Data
	@GetMapping("/user")
	public ResponseEntity<?> getAllUsersData
	       (@Valid @RequestParam(defaultValue = "")String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "12") String pageSize) {
		Page<User> user = userService.getAllUsers(search, pageNumber, pageSize);

		if (user.getTotalElements() != 0) {

			System.out.println("hello1");

			return new ResponseEntity<>(new  Message("Success","Success",user.getContent()),HttpStatus.OK)  ;  

		}
		return new ResponseEntity<>(new ErrorResponceDto("Data Not Found", "Data Not Found"),HttpStatus.BAD_REQUEST);
	}
	// get user by id
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getByuserId(@Valid @PathVariable Integer id) {

		try {
			User user = userService.getByUserId(id);

			return new ResponseEntity<>(new Message("Success", "Success", user), HttpStatus.OK);

		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(new ErrorResponceDto(e.getMessage(), "Access Denied"), HttpStatus.BAD_GATEWAY);
		}
	}

	// update users
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer id) {
		try {
			UserDto userDto1 = this.userService.updateUser(userDto, id);
			return new ResponseEntity<>(new Message("success", "success", userDto1), HttpStatus.OK);

		} catch (ResourceNotFoundException exception) {
			return new ResponseEntity<>(new ErrorResponceDto(exception.getMessage(), "User Not Found"),
					HttpStatus.BAD_REQUEST);
		}

	}

	// delete user by id
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}

}
