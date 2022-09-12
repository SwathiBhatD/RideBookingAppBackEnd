package com.ridebookingapp.services;

import org.springframework.beans.factory.annotation.Autowired;
//import  org.springframework.security.crypto.bcrypt;
import org.springframework.stereotype.Service;

//import com.ridebookingapp.exception.UserNotFoundException;
import com.ridebookingapp.model.User;
import com.ridebookingapp.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	public User fetchUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	public User fetchUserByEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email,password);
	}
//	public void upadateResetPassword(String token,String email) throws  UserNotFoundException{
//		User user=repo.findByEmail(email);
//		if(user!=null) {
//			user.setReset_pwd_token(token);
//			repo.save(user);
//		}
//		else {
//			throw new UserNotFoundException("Could not find any user with mail"+email);
//		}
//	}
//	
////	public User get(String resetpasswordToken)
////	{
////		return repo.findByResetPasswordToken(resetpasswordToken);
////	}
//	public void updatePassword(User user, String newPassword) {
////		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
////			String encodePassword=	passwordEncoder.encode(newPassword);
//		user.setPassword(newPassword);
//		user.setReset_pwd_token(null);
//		repo.save(user);
//	}
}
