package com.example.groupproject.controllers;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.groupproject.models.Task;
import com.example.groupproject.models.TaskRepository;
import com.example.groupproject.models.User;
import com.example.groupproject.models.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

  @Autowired
  UserRepository userRepository;
  
  @PostMapping("/register")
  public User addUser(@RequestBody User user) {
    return userRepository.save(user);
  }
  @GetMapping("/login/{username}")
  public User getUser(@PathVariable String username) {
	  User foundUser = userRepository.findByUsername(username);
	    if (foundUser != null ) {
	      return foundUser;
	    }
	    return null;
	  }
}