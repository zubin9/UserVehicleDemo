package com.example.uservehicledemo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uservehicledemo.dto.UserDTO;
import com.example.uservehicledemo.model.User;
import com.example.uservehicledemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired	
	private UserRepository userRepository;
	
	public String createUser(UserDTO userdto) {
		User user = modelMapper.map(userdto, User.class);
		userRepository.save(user);		
		return "User is created with ID: " + String.valueOf(user.getId());
	}
}
