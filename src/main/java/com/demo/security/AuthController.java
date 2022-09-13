
package com.demo.security;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.demo.ServiceImpl.AuthServiceImpl;
import com.demo.dto.AuthResponceDto;
import com.demo.dto.LoggerDto;
import com.demo.dto.UserDto;
import com.demo.entity.User;
import com.demo.exception.ErrorResponceDto;
import com.demo.exception.Message;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.UserRepository;
import com.demo.service.LoggerServiceInterface;
import com.demo.service.UserService;
import com.demo.utility.PasswordValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Auth")
public class AuthController {

	@Autowired
	private AuthServiceImpl authServiceImpl;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	LoggerServiceInterface loggerServiceInterface;

	@PostMapping("/login")
	public ResponseEntity<?> createToken(@RequestBody JwtAuthRequest authenticationResuest)
			throws Exception, ResourceNotFoundException {
		try {
			User user = userRepository.findByEmail(authenticationResuest.getEmail());

			if (authServiceImpl.comaprePassword(authenticationResuest.getPassword(), user.getPassword())) {

				final UserDetails userDetails = this.userDetailsService
						.loadUserByUsername(authenticationResuest.getEmail());

				final String token = jwtTokenUtil.generateToken(userDetails);

				LoggerDto loggerDto = new LoggerDto();

				loggerDto.setToken(token);

				Calendar calender = Calendar.getInstance();

				calender.add(Calendar.HOUR_OF_DAY, 8);

				loggerDto.setExpireAt(calender.getTime());

				loggerServiceInterface.createLogger(loggerDto, user);

				return ResponseEntity.ok(new Message("Login Successfull", "token",
						new AuthResponceDto(token, user.getEmail(), user.getName(), user.getId())));

			} else {
				throw new Exception("Invalid username or password");

			}
		} catch (ResourceNotFoundException e) {

			return ResponseEntity.ok(new ErrorResponceDto("Invalid email or Password", "Invalid"));
		}

	}

	@PostMapping("/register")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto, HttpServletRequest request)
			throws Exception, DataIntegrityViolationException {

		String email = userDto.getEmail();
		String password = userDto.getPassword();

		if (PasswordValidator.isValid(password)&&(PasswordValidator.isValidforEmail(email))) {
			User databaseName = userRepository.findByEmail(email);
			if (databaseName == null) {
				userService.save(userDto);
				return new ResponseEntity<>(new Message("User Created", "userCreated", "data added"),
						HttpStatus.CREATED);

			} else {
				return new ResponseEntity<>(
						new ErrorResponceDto("User Email Id Already Exist", "userEmailIdAlreadyExist"),
						HttpStatus.BAD_REQUEST);
			}
		} else {

			return ResponseEntity.ok(new ErrorResponceDto(
					"Password should have Minimum 8 and maximum 50 characters, at least one uppercase letter, one lowercase letter, one number and one special character and No White Spaces",
					"Password validation not done"));

		}
	}

	@Transactional
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<?> logoutUser(@RequestHeader("Authorization") String token, HttpServletRequest request) {
		loggerServiceInterface.logout(token);
		return new ResponseEntity<>(new ErrorResponceDto("Logout Successfully", "logoutSuccess"), HttpStatus.OK);

	}

}
