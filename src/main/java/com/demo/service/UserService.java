package com.demo.service;

import com.demo.dto.UserDto;
import com.demo.entity.User;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.UserRepository;
import com.demo.utility.Pagination;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	
	
	
	// add user
		
		public User save(UserDto userDto) {
			User user=new User();
			user.setEmail(userDto.getEmail());
			user.setMobileNumber(userDto.getMobileNumber());
			user.setName(userDto.getName());
			user.setPassword(passwordEncoder.encode(userDto.getPassword()));
			
			return this.userRepository.save(user);
			
		}
	
	
	// update user by id

	public UserDto updateUser(UserDto userDto, Integer id) {
		User user = this.userRepository.findById(id).orElseThrow();

		user.setName(userDto.getName());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setEmail(userDto.getEmail());
	//	user.setPassword(userDto.getPassword());

		UserDto saveUser = this.userToDto(user);
		return saveUser;

	}

	// get all users

	public Page<User> getAllUsers(String search, String pageNo, String pageSize) {

		Pageable pageable = new Pagination().getPegination(pageNo, pageSize);

		if ((search == "") || (search == null) || (search.length() == 0)) {

			return userRepository.findByOrderById(pageable, User.class);
		} else

			return userRepository.findByNameIgnoreCaseContaining(search, pageable, User.class);

	}	
	
	

	// get user by id

	public User getByUserId(Integer id) throws ResourceNotFoundException {
		User userDto = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RESOURCE NOT FOUND"));
		return userDto;
	}

	
	

	// delete user by id

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);

	}

	// User To Dto
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);

		return userDto;

	}

	// Dto to User

	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;

	}
	
//	public void addUserRole(List<RoleEntity> entity , int id) {
//		List<RoleEntity> list = new ArrayList();
//		User user = userRepository.findById(id).get();
//		for(RoleEntity roleEntity:list) {
//			roleEntity.getId();
//			RoleEntity roleEntity1 = this.roleEntityRepository.findById(roleId);
//			
//				
//			 
//			 
//			
//		}
//	}
	
//	public void addRoleToUser(Integer userId,Integer roleId) {
//		User user = this.userRepository.findById(roleId).get();
//		System.out.println("User"+user);	
//		RoleEntity role = roleEntityRepository.findById(userId).get();
//		System.out.println("role"+role);
//		user.getRoles().add(role);
//		userRepository.save(user);
//		System.out.println(user.getRoles().add(role));
//		
//		
	}
	

	
	
	


