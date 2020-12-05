package com.example.uservehicledemo.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "VEHICLE_MAINTAINANCE_DATA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleMaintainance {

	@Id
	@SequenceGenerator(name="VEHICLE_MAINTAINACE_SEQUENCE", sequenceName="VEH_MAINTAINANCE_SEQ", initialValue=101, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="VEHICLE_MAINTAINACE_SEQUENCE")
	@Column(name = "VEH_MAINTAINANCE_ID")
	private long id;
	
	@Column(name = "MAINTAINANCE_COST", nullable = false)
	private long maintainanceCost;
	
	@Column(name = "MAINTAINANCE_DATE", nullable = false)
	private Date maintainanceDate;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	@ManyToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
	
}
