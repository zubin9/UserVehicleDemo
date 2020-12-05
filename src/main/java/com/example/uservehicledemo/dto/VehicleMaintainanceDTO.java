package com.example.uservehicledemo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class VehicleMaintainanceDTO {

	private long vehicleId;
	private long maintainanceId;
	private long maintainanceCost;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date maintainanceDate;
	
	private String comments;
}
