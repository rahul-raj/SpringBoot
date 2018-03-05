package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	@NotEmpty(message = "NotEmpty.Password")
	private String password;
	
	@Column(name="email")
	@Email(message = "{NotEmpty.Email}")
	@NotEmpty(message = "{Invalid.Email}")
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
