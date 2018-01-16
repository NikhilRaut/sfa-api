package com.nikhil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.nikhil.bo.InvoiceBo;
import com.nikhil.model.Invoice;
import com.nikhil.util.JsonConverterUtil;
import com.nikhil.util.RestURIConstants;

@Controller
public class InvoiceController {

	@Autowired
	InvoiceBo bo;

	@RequestMapping(value = RestURIConstants.GET_INVOICES, method = RequestMethod.GET)
	public @ResponseBody String retailerOrders(
			@RequestParam(value = "retailer_code", required = false) String retailerId,
			@RequestParam(value = "dsr_code", required = false) String dsrId) {

		JsonObject object = new JsonObject();
		try {
			List<Invoice> list;
			if (!StringUtils.isEmpty(retailerId)) {
				list = bo.retailerInvoices(retailerId);
				object.add("invoices", JsonConverterUtil.invoiceListToJson(list));
				object.addProperty("status", list.isEmpty() ? 0 : 1);
				object.addProperty("message", list.isEmpty() ? "No invoice found " : "invoice list successfully.");
			} else if (!StringUtils.isEmpty(dsrId)) {
				list = bo.dsrRetailerInvoices(dsrId);
				System.out.println("Order -----------------------------" + list.size());
				object.add("invoices", JsonConverterUtil.invoiceListToJson(list));
				object.addProperty("status", list.isEmpty() ? 0 : 1);
				object.addProperty("message", list.isEmpty() ? "No invoice found " : "invoice list successfully.");
			} else {
				object.addProperty("status", 0);
				object.addProperty("message", "Invaild input !! ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			object.addProperty("status", 0);
			object.addProperty("message", "Error while getting invoice : " + e.getMessage());
		}
		return object.toString();

	}
}
