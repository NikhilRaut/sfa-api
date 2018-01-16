package com.nikhil.bo;

import java.util.List;

import com.nikhil.model.Invoice;

public interface InvoiceBo {
	List<Invoice> retailerInvoices(String retailerCode);

	List<Invoice> dsrRetailerInvoices(String dsrCode);
}
