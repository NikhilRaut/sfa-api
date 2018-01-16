package com.nikhil.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="gm_orderpart")
public class Orders implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ORDERS = "orderItems";
	
	private long id;		
	private String orderNumber;		
	private String orderStatus;
	private String orderDate;	
	private String retailerId;	
	private String dsrId;	
	private List<OrderItem> orderItems =  new ArrayList<OrderItem>();
	
	public Orders() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="order_number")
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name="order_date")
	public String getOrderDate() {
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(orderDate);
			String newstring = new SimpleDateFormat("dd-MM-yyyy").format(date);
			System.out.println(newstring); // 2011-01-1
			return newstring;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@OneToMany(mappedBy= "orders")
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	

	@Column(name="order_status")
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name="retailer_id")
	public String getRetailerId() {
		return retailerId;
	}


	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}
	
	@Column(name="dsr_id")
	public String getDsrId() {
		return dsrId;
	}

	
	public void setDsrId(String dsrId) {
		this.dsrId = dsrId;
	}


	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderNumber=" + orderNumber + ", orderStatus=" + orderStatus + ", orderDate="
				+ orderDate + ", retailerId=" + retailerId + ", orderItems=" + orderItems + "]";
	}
	
	
}
