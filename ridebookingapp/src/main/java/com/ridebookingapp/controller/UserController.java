package com.ridebookingapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ridebookingapp.model.User;
import com.ridebookingapp.services.UserServices;

import net.bytebuddy.utility.RandomString;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1.0/rideapp")
public class UserController {
	
	@Autowired
	private UserServices userService;
	

	@PostMapping("/register")
	public User registerUser( @RequestBody User user) throws Exception{
		String tempEmail=user.getEmail();
		if(tempEmail != null && ! "".equals(tempEmail)) {
			User userobj=userService.fetchUserByEmail(tempEmail);
			if(userobj != null) {
				throw new Exception("User with "+tempEmail+" is already exist");
			}
		}
		User userObj=null;
		userObj=userService.saveUser(user);
		return userObj;
		
	}
//	public ResponseEntity<User> registerUser( @RequestBody User user){
//		return ResponseEntity.ok(userRepository.save(user));
//		
//	}
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail=user.getEmail();
		String tempPassword =user.getPassword();
		User userObj=null;
		
		if(tempEmail != null && tempPassword != null) {
			userObj=userService.fetchUserByEmailAndPassword(tempEmail, tempPassword);
		}
		if(userObj==null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	}
//	@PostMapping("/forgot")
//	public User forgotPwd(@RequestBody User user) {
//		String email=user.getEmail();
//		String token=RandomString.make(45);
//		System.out.println("Email: "+email);
//		System.out.println("Token: "+token);
//		return null;
//		
//	}

}
