package com.ridebookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ridebookingapp.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
	public User findByEmail(String email) ;
	public User findByEmailAndPassword(String email, String Password) ;
	
//	public User findByResetPasswordToken(String token);
}
