package com.example.uservehicledemo.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserVehicleDTO {

	private long userId;
	private List<Long> vehicleIds;
	
	private long vehicleId;
	private long oldUserId;
	private long newUserId;
	
}
