package com.example.uservehicledemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.uservehicledemo.dto.VehicleMaintainanceDTO;
import com.example.uservehicledemo.service.VehicleMaintainanceService;

@RestController
public class VehicleMaintainanceController {
	
	@Autowired
	private VehicleMaintainanceService vehicleMaintainanceService;
	
	@PostMapping("/addVehicleMaintainanceData")
	public ResponseEntity<String> addVehicleMaintainanceData(@RequestBody VehicleMaintainanceDTO vehicleMaintainanceDTO) {		
		vehicleMaintainanceService.addVehicleMaintainanceRecord(vehicleMaintainanceDTO);
		String response = "Maintainance data added successfully for vehicle[" + vehicleMaintainanceDTO.getVehicleId() +"]";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/updateVehicleMaintainanceData")
	public ResponseEntity<String> updateVehicleMaintainanceData(@RequestBody VehicleMaintainanceDTO vehicleMaintainanceDTO) throws Exception {
		String response =  vehicleMaintainanceService.updateMaintainanceRecord(vehicleMaintainanceDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/deleteVehicleMaintainanceData")
	public ResponseEntity<String> deleteMaintainanceData(@RequestBody VehicleMaintainanceDTO vehicleMaintainanceDTO) throws Exception {
		String response =  vehicleMaintainanceService.deleteMaintainanceRecord(vehicleMaintainanceDTO.getMaintainanceId());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
