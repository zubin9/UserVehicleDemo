package com.example.uservehicledemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VEHICLE_DATA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

	@Id
	@SequenceGenerator(name="VEHICLE_SEQUENCE", sequenceName="VEHICLE_SEQ", initialValue=101, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="VEHICLE_SEQUENCE")
	@Column(name = "VEHICLE_ID")
	private long id;
	
	@Column(name = "VEHICLE_TYPE", nullable = false)
	private String vehicleType;
	
	@Column(name = "VEHICLE_NUMBER", nullable = false)
	private String vehicleNumber;
	
	@Column(name = "MANUFACTURE_YEAR", nullable = false)
	private int manufactureYear;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
}
