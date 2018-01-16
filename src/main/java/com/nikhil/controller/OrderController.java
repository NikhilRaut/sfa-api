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
import com.nikhil.bo.OrderBo;
import com.nikhil.model.Orders;
import com.nikhil.util.JsonConverterUtil;
import com.nikhil.util.RestURIConstants;

@Controller
public class OrderController {

	@Autowired
	OrderBo orderBo;

	@RequestMapping(value = RestURIConstants.GET_RETAILE_ORDER, method = RequestMethod.GET)
	public @ResponseBody String retailerOrders(@RequestParam(value = "retailer_code", required = false) String retailerId,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "dsr_code", required = false) String dsrId) {

		JsonObject object = new JsonObject();
		try {
			List<Orders> list;
			if (!StringUtils.isEmpty(retailerId) && !StringUtils.isEmpty(date)) {
				list = orderBo.retailerOrdersForDate(retailerId, date, date + "23:59:59");
				object.add("orders", JsonConverterUtil.orderListToJson(list));
				object.addProperty("status", list.isEmpty() ? 0 : 1);
				object.addProperty("message", list.isEmpty() ? "No order found " : "Order list successfully.");
			} else if (!StringUtils.isEmpty(dsrId) && !StringUtils.isEmpty(date)) {
				list = orderBo.dsrOrdersForDate(dsrId, date, date + "23:59:59");
				System.out.println("Order -----------------------------" + list.size());
				object.add("orders", JsonConverterUtil.orderListToJson(list));
				object.addProperty("status", list.isEmpty() ? 0 : 1);
				object.addProperty("message", list.isEmpty() ? "No order found " : "Order list successfully.");
			} else if (!StringUtils.isEmpty(retailerId)) {
				list = orderBo.retailerOrders(retailerId);
				System.out.println("Order -----------------------------" + list.size());
				object.add("orders", JsonConverterUtil.orderListToJson(list));
				// object.addProperty("orders",list.toString());
				object.addProperty("status", list.isEmpty() ? 0 : 1);
				object.addProperty("message", list.isEmpty() ? "No order found " : "Order list successfully.");
			} else {
				object.addProperty("status", 0);
				object.addProperty("message", "Invaild input !! ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			object.addProperty("status", 0);
			object.addProperty("message", "Error while getting order : " + e.getMessage());
		}
		return object.toString();

	}
}
