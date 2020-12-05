package com.example.uservehicledemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.uservehicledemo.UservehicledemoApplication;
import com.example.uservehicledemo.dto.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UservehicledemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void testCreateUser() {		
		UserDTO user = new UserDTO();		
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setCountry("IND");
		user.setAge(35);

		ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/createUser", user, String.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertEquals(HttpStatus.OK, postResponse.getStatusCode());
	}	
}
