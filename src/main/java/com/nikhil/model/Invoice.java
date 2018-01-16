package com.nikhil.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@Table(name = "gm_invoices")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "invoice_id")
	private String invoiceId;

	@Column(name = "invoice_amount")
	private String invoiceAmount;

	@Column(name = "paid_amount")
	private String paidAmount;

	@Column(name = "invoice_date")
	private String date;

//	
//	@Column(name = "retailer_id")
//	private String retailerId;
//	
	
	@JoinColumn(name = "retailer_id")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Retailer retailer;
	
	public Invoice() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getDate() {
		Date d;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(date);
			String newstring = new SimpleDateFormat("dd-MM-yyyy").format(d);
			System.out.println(newstring); // 2011-01-1
			return newstring;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
//
//	public String getRetailerId() {
//		return retailerId;
//	}
//
//	public void setRetailerId(String retailerId) {
//		this.retailerId = retailerId;
//	}
//	
//	

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", invoiceId=" + invoiceId + ", invoiceAmount=" + invoiceAmount + ", paidAmount="
				+ paidAmount + ", date=" + date + ", retailer=" + retailer + "]";
	}
	
	

}
