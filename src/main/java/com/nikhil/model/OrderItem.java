package com.nikhil.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "gm_orderpart_details")
public class OrderItem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	// @Column(name = "part_number_id")
	// private String partNumber;

	@Column(name = "quantity")
	private String partQuantity;

	@Column(name = "line_total")
	private String lineTotal;
	
	@JoinColumn(name = "part_number_id")
	@OneToOne( cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Product part;

	@JoinColumn(name = "order_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Orders orders;
	
//	@Transient
//	private String partNumber;
//	@Transient
//	private String partName;
//	@Transient
//	private String partM	RP;
//	@Transient
//	private String partModel;

	public OrderItem() {
	}

	public OrderItem(long id, Product part, String partQuantity, String lineTotal) {
		super();
		this.id = id;
		this.part = part;
		this.partQuantity = partQuantity;
		this.lineTotal = lineTotal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPartQuantity() {
		return partQuantity;
	}

	public void setPartQuantity(String partQuantity) {
		this.partQuantity = partQuantity;
	}

	public String getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(String lineTotal) {
		this.lineTotal = lineTotal;
	}

	public Product getPart() {
		return part;
	}

	public void setPart(Product part) {
		this.part = part;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

//	public String getPartNumber() {
//		return part.getPartNumber();
//	}
//
//	public void setPartNumber(String partNumber) {
//		this.partNumber = partNumber;
//	}
//
//	public String getPartName() {
//		return part.getDescription();
//	}
//
//	public void setPartName(String partName) {
//		this.partName = partName;
//	}
//
//	public String getPartMRP() {
//		return part.getPartMRP();
//	}
//
//	public void setPartMRP(String partMRP) {
//		this.partMRP = partMRP;
//	}
//
//	public String getPartModel() {
//		return part.getApplicableModel();
//	}
//
//	public void setPartModel(String partModel) {
//		this.partModel = partModel;
//	}
//
//	@Override
//	public String toString() {
//		return "OrderItem [id=" + id + ", partQuantity=" + partQuantity + ", lineTotal=" + lineTotal + ", part=" + part
//				+ ", orders=" + orders + ", partNumber=" + partNumber + ", partName=" + partName + ", partMRP="
//				+ partMRP + ", partModel=" + partModel + "]";
//	}


}
