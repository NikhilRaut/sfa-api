package com.nikhil.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nikhil.model.Invoice;

@Repository
public interface InvoiceDao {
	List<Invoice> retailerInvoices(String retailerCode);

	List<Invoice> dsrRetailerInvoices(String dsrCode);
}
