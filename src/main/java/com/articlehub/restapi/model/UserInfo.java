package com.articlehub.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo")
public class UserInfo {

   
    private int id;    
    private String fullname;
    private String email;
    private String phone;
    private String username;
    private String password;
    
    public UserInfo() {
    	  
    }
 
    public UserInfo(String fullname, String email, String phone, String username, String password) {
    	this.fullname = fullname;
    	this.email = email;
    	this.phone = phone;
    	this.username = username;
    	this.password = password;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "fullname", nullable = false)
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public String toString() {
        return "UserInfo [id=" + id + ", fullname=" + fullname + ", email=" + email + ", phone=" + phone
       + ",username=" + username+", password="+ password+"]";
    }
}