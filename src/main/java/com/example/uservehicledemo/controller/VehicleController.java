package com.example.uservehicledemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.uservehicledemo.dto.UserVehicleDTO;
import com.example.uservehicledemo.dto.VehicleDTO;
import com.example.uservehicledemo.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/createVehicle")
	public ResponseEntity<String> createVehicle(@RequestBody VehicleDTO vehicleDto) {
		String response = vehicleService.createVehicle(vehicleDto);
		return new ResponseEntity<>(response, HttpStatus.OK);		
	}
	
	@PostMapping("/addVehiclesToUser")
	public ResponseEntity<String> addVehiclesToUser(@RequestBody UserVehicleDTO userVehicleDto) throws Exception {
		vehicleService.addVehiclesToUser(userVehicleDto);
		String response = "Vehicle(s) " + userVehicleDto.getVehicleIds() +" is/are added to User[" + userVehicleDto.getUserId() + "]";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/updateVehicleOwnership")
	public ResponseEntity<String> updateVehicleOwnership(@RequestBody UserVehicleDTO userVehicleDto) throws Exception {
		vehicleService.updateVehicleOwnership(userVehicleDto);
		String response = "Ownership for Vehicle [" + userVehicleDto.getVehicleId() + "] is updated successfully";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
