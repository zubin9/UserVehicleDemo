package com.example.uservehicledemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_DATA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@SequenceGenerator(name="USER_SEQUENCE", sequenceName="USER_SEQ", initialValue=101, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="USER_SEQUENCE")
	@Column(name = "USER_ID")
	private long id;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	@Column(name = "AGE", nullable = false)
	private int age;
	
	@Column(name = "COUNTRY")
	private String country;
}
