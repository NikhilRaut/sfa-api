package com.nikhil.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gm_partpricing")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "part_number")
	private String partNumber;
	@Column(name = "description")
	private String description;
	@Column(name = "mrp")
	private String partMRP;
	@Column(name = "applicable_model")
	private String applicableModel;
	
	@Column(name = "modified_date")
	private String modifiedDate;

	@JoinColumn(name= "subcategory_id")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ProductCategory category;
	
	public Product() {
	}

	public Product(long id, String partNumber, String description, String partMRP, String hsnCode, String applicableModel,
			OrderItem orderItem) {
		super();
		this.id = id;
		this.partNumber = partNumber;
		this.description = description;
		this.partMRP = partMRP;
		this.applicableModel = applicableModel;
		// this.orderItem = orderItem;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPartMRP() {
		return partMRP;
	}

	public void setPartMRP(String partMRP) {
		this.partMRP = partMRP;
	}

	public String getApplicableModel() {
		return applicableModel;
	}

	public void setApplicableModel(String applicableModel) {
		this.applicableModel = applicableModel;
	}

	
	
	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Part [id=" + id + ", partNumber=" + partNumber + ", description=" + description + ", partMRP=" + partMRP
				+ ", applicableModel=" + applicableModel + "]";
	}
	
	

}
