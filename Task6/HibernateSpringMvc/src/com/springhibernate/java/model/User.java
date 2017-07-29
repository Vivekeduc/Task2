package com.springhibernate.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Annotation
@Entity
@Table(name="user")
public class User {
  @Id
  @Column(name = "userId")
  private int userId;
  @Column(name = "password")
  private String password;
  @Column(name = "email")
  private String email;
  @Column(name = "phone")
  private String phone;
  @Column(name = "city")
  private String city;
  
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
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

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}
@Override
public String toString(){
	return "userId="+userId+", password="+password+", email="+email+",phone="+phone+", city="+city;
}
  
}