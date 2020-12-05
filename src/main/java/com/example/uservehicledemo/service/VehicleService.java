package com.example.uservehicledemo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uservehicledemo.dto.UserVehicleDTO;
import com.example.uservehicledemo.dto.VehicleDTO;
import com.example.uservehicledemo.exception.ResourceNotFoundException;
import com.example.uservehicledemo.model.Vehicle;
import com.example.uservehicledemo.repository.UserRepository;
import com.example.uservehicledemo.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired	
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String createVehicle(VehicleDTO vehicleDto) {
		Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
		vehicleRepository.save(vehicle);
		return "Vehicle is created with ID: " + String.valueOf(vehicle.getId());
	}
	
	public void addVehiclesToUser(UserVehicleDTO userVehicleDto) throws Exception {
		
		if(!userRepository.existsById(userVehicleDto.getUserId())) {
			throw new ResourceNotFoundException("User with Id: " + userVehicleDto.getUserId() + " not exists");
		}
		
		for(Long vehicleId : userVehicleDto.getVehicleIds()) {
			if(!vehicleRepository.existsById(vehicleId)) {
				throw new ResourceNotFoundException("Vehicle with Id: " + vehicleId + " not exists");
			}
		}
		
		vehicleRepository.addVehiclesToUsers(userVehicleDto.getVehicleIds(), userVehicleDto.getUserId());				
	}
	
	public void updateVehicleOwnership(UserVehicleDTO userVehicleDto) throws Exception {
		
		if(!vehicleRepository.existsById(userVehicleDto.getVehicleId())) {
			throw new ResourceNotFoundException("Vehicle with Id: " + userVehicleDto.getVehicleId() + " not exists");
		}
		
		if(!userRepository.existsById(userVehicleDto.getOldUserId())) {
			throw new ResourceNotFoundException("User with Id: " + userVehicleDto.getOldUserId() + " not exists");
		}
		
		if(!userRepository.existsById(userVehicleDto.getNewUserId())) {
			throw new ResourceNotFoundException("User with Id: " + userVehicleDto.getNewUserId() + " not exists");
		}
		
		//Need to check if previous owner is correct or not.
		if(vehicleRepository.getCurrentOwnerId(userVehicleDto.getVehicleId()).equals(userVehicleDto.getOldUserId())) {
			vehicleRepository.updateVehicleOwnership(userVehicleDto.getNewUserId(), userVehicleDto.getVehicleId());			
		} else {
			throw new Exception("User [" + userVehicleDto.getOldUserId() + "] is not the current owner of the Vehicle [" + userVehicleDto.getVehicleId() + "]");
		}		
	}
}
