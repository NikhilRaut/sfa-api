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
import com.nikhil.dao.RetailerDao;
import com.nikhil.model.Retailer;
import com.nikhil.util.JsonConverterUtil;
import com.nikhil.util.RestURIConstants;

@Controller
public class RetailerController {
	@Autowired
	RetailerDao retailerDao;

	@RequestMapping(value = RestURIConstants.GET_RETAILE, method = RequestMethod.GET)
	public @ResponseBody String retailerOrders(@RequestParam(value = "dsr_code", required = false) String dsrCode) {

		JsonObject object = new JsonObject();
		try {
			List<Retailer> list;
			if (!StringUtils.isEmpty(dsrCode)) {
				list = retailerDao.dsrRetailerList(dsrCode);
				System.out.println("Retailerr -----------------------------" + list.size());
				object.add("orders", JsonConverterUtil.retailerListToJson(list));
				object.addProperty("status", list.isEmpty() ? 0 : 1);
				object.addProperty("message", list.isEmpty() ? "No order found " : "Retailer list successfully.");
			} else {
				object.addProperty("status", 0);
				object.addProperty("message", "Invaild input !! ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			object.addProperty("status", 0);
			object.addProperty("message", "Error while getting retailer : " + e.getMessage());
		}
		return object.toString();
	}

	
	
}
