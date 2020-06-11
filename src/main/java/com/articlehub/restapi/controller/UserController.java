package com.articlehub.restapi.controller;

//import com.articlehub.restapi.exceptions.ValidationException;
//import com.articlehub.restapi.model.JwtResponse;
import com.articlehub.restapi.model.UserInfo;
import com.articlehub.restapi.repository.UserInfoRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class UserController {


    final
    private UserInfoRepository userInfoRepository;

//    private HashData hashData = new HashData();

    public UserController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


    // register new user
    @PostMapping("/register")
    public ResponseEntity<UserInfo> create(@RequestBody UserInfo  body) {
        String username = body.getUsername();
        if (userInfoRepository.existsByUsername(username)){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

        String password = body.getPassword();
        String email = body.getEmail();
        String phone = body.getPhone();
        String encodedPassword = new BCryptPasswordEncoder().encode(password);

        String fullname = body.getFullname();
        return new ResponseEntity<>(userInfoRepository.save(new UserInfo(fullname, email, phone, username, encodedPassword)), HttpStatus.OK);
    }
    
    // fetch all users
    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> fetchUsers() {
    	return new ResponseEntity<>(userInfoRepository.findAll(), HttpStatus.OK);
    }

}
