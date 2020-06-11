package com.articlehub.restapi.service;

import com.articlehub.restapi.model.UserInfo;
import com.articlehub.restapi.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	 @Autowired
	 private UserInfoRepository userInfoRepository;


	 @Override
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	     UserInfo user = userInfoRepository.findByUsername(username);
	     if (user == null) {
	          throw new UsernameNotFoundException("User not found with username: " + username);
	     }
	     return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
	              new ArrayList<>());
	}
}
