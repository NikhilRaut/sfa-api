package com.nikhil.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikhil.bo.InvoiceBo;
import com.nikhil.dao.InvoiceDao;
import com.nikhil.model.Invoice;

@Repository("invoiceBo")
public class InvoiceBoImpl implements InvoiceBo {
	
	@Autowired
	InvoiceDao invoiceDao;

	public List<Invoice> retailerInvoices(String retailerCode) {
		return invoiceDao.retailerInvoices(retailerCode);
	}

	public List<Invoice> dsrRetailerInvoices(String dsrCode) {
		return invoiceDao.dsrRetailerInvoices(dsrCode);
	}

}
