package com.example.uservehicledemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.uservehicledemo.dto.UserDTO;
import com.example.uservehicledemo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody UserDTO userdto) {
		String response = userService.createUser(userdto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
