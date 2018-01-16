package com.nikhil.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gm_retailer")
public class Distributor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "user_id")
	private long userId;	
	
	@Column(name = "phone_number")
	private String mobile;
	
	@Column(name = "email_bajaj")
	private String email;
	
	@Column(name = "distributor_id")
	private String distributorId;
	
	@Column(name = "dsr_id")
	private String dsrId;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "locality_id")
	private String localityId;
}
