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
import com.nikhil.bo.ProductBo;
import com.nikhil.model.Product;
import com.nikhil.util.JsonConverterUtil;
import com.nikhil.util.RestURIConstants;

@Controller
public class ProductController {

	@Autowired
	ProductBo productBo;

	@RequestMapping(value = RestURIConstants.GET_PRODUCTS, method = RequestMethod.GET)
	public @ResponseBody String retailerOrders(@RequestParam(value = "last_sync", required = false) String lastSync,
			@RequestParam(value = "offset", required = false) String offset,
			@RequestParam(value = "limit", required = false) String limit) {

		JsonObject object = new JsonObject();
		try {
			List<Product> list;
			if (!StringUtils.isEmpty(lastSync) && !StringUtils.isEmpty(offset) && !StringUtils.isEmpty(limit)) {
				list = productBo.product(lastSync, Integer.parseInt(offset), Integer.parseInt(limit));
				object.addProperty("count", list.size());
				object.add("product", JsonConverterUtil.productListToJson(list));
				object.addProperty("status", list.isEmpty() ? 0 : 1);
				object.addProperty("message", list.isEmpty() ? "No product found " : "product list successfully.");
			} else if (!StringUtils.isEmpty(offset) && !StringUtils.isEmpty(limit)) {
				list = productBo.product(Integer.parseInt(offset), Integer.parseInt(limit));
				object.addProperty("count", list.size());
				object.add("product", JsonConverterUtil.productListToJson(list));
				object.addProperty("status", list.isEmpty() ? 0 : 1);
				object.addProperty("message", list.isEmpty() ? "No product found " : "product list successfully.");
			} else if (!StringUtils.isEmpty(lastSync)) {
				list = productBo.product(lastSync);
				object.addProperty("count", list.size());
				object.add("product", JsonConverterUtil.productListToJson(list));
				object.addProperty("status", list.isEmpty() ? 0 : 1);
				object.addProperty("message", list.isEmpty() ? "No product found " : "product list successfully.");
			} else {
				list = productBo.product();
				object.addProperty("count", list.size());
				object.add("product", JsonConverterUtil.productListToJson(list));
				object.addProperty("status", list.isEmpty() ? 0 : 1);
				object.addProperty("message", list.isEmpty() ? "No product found " : "product list successfully.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			object.addProperty("status", 0);
			object.addProperty("message", "Error while getting invoice : " + e.getMessage());
		}
		return object.toString();

	}
}
