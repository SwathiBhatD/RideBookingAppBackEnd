package com.ridebookingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;



@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@NotNull
	@Column(name="cpassword")
	private String cpassword;
	
	@Column(name="reset_pwd_token")
	private String reset_pwd_token;

	
	public User() {
		
	}
	public User(String name, String email, String password, String cpassword, String reset_pwd_token) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
		this.reset_pwd_token=reset_pwd_token;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getReset_pwd_token() {
		return reset_pwd_token;
	}
	public void setReset_pwd_token(String reset_pwd_token) {
		this.reset_pwd_token = reset_pwd_token;
	}
	
}
