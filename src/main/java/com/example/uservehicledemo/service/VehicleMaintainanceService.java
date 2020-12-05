package com.example.uservehicledemo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.uservehicledemo.dto.VehicleMaintainanceDTO;
import com.example.uservehicledemo.exception.ResourceNotFoundException;
import com.example.uservehicledemo.model.Vehicle;
import com.example.uservehicledemo.model.VehicleMaintainance;
import com.example.uservehicledemo.repository.VehicleMaintainanceRepository;
import com.example.uservehicledemo.repository.VehicleRepository;

@Service
@Transactional
public class VehicleMaintainanceService {

	@Autowired
    private ModelMapper modelMapper;
		
	@Autowired
	private VehicleRepository vehicleRepository;
		
	@Autowired
	private VehicleMaintainanceRepository vehicleMaintainanceRepository;
	
	public Long addVehicleMaintainanceRecord(VehicleMaintainanceDTO vehicleMaintainanceDTO) {
		VehicleMaintainance vm = modelMapper.map(vehicleMaintainanceDTO, VehicleMaintainance.class);
		Vehicle vehicle = vehicleRepository.getOne(vehicleMaintainanceDTO.getVehicleId());
		vm.setVehicle(vehicle);		
		vehicleMaintainanceRepository.save(vm);
		return vm.getId();
	}	
	
	public String updateMaintainanceRecord(VehicleMaintainanceDTO vehicleMaintainanceDTO) throws Exception {
		VehicleMaintainance vm = modelMapper.map(vehicleMaintainanceDTO, VehicleMaintainance.class);
		vm.setId(vehicleMaintainanceDTO.getMaintainanceId());
		vm.setVehicle(vehicleRepository.getOne(vehicleMaintainanceRepository.getOne(vehicleMaintainanceDTO.getMaintainanceId()).getVehicle().getId()));
		if(vehicleMaintainanceRepository.existsById(vehicleMaintainanceDTO.getMaintainanceId())) {			
			vehicleMaintainanceRepository.save(vm);
		} else {
			throw new ResourceNotFoundException("VehicleMaintainance Record with Id: " + vehicleMaintainanceDTO.getMaintainanceId() + " not exists");
		}
		return "Maintainance record ["+ vehicleMaintainanceDTO.getMaintainanceId() + "] is updated";
	}
	
	public String deleteMaintainanceRecord(long vehicleMaintainanceId) throws ResourceNotFoundException {
		if(vehicleMaintainanceRepository.existsById(vehicleMaintainanceId)) {
			vehicleMaintainanceRepository.deleteById(vehicleMaintainanceId);
		} else {
			throw new ResourceNotFoundException("VehicleMaintainance Record with Id: " + vehicleMaintainanceId + " not exists");
		}
		return "Maintainance record ["+ vehicleMaintainanceId + "] is deleted";
	}
}
