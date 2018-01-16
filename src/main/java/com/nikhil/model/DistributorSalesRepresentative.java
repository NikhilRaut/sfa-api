package com.nikhil.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gm_distributorsalesrep")
public class DistributorSalesRepresentative {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "distributor_sales_code")
	private String code;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "distributor_id")
	private String distributorId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}

	@Override
	public String toString() {
		return "DistributorSalesRepresentative [id=" + id + ", userId=" + userId + ", code=" + code + ", email=" + email
				+ ", distributorId=" + distributorId + "]";
	}
	
	
		

}
