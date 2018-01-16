package com.nikhil.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nikhil.model.Invoice;
import com.nikhil.model.Orders;
import com.nikhil.model.Product;
import com.nikhil.model.Retailer;
import com.nikhil.model.Stock;

//import com.model.Orders;

import flexjson.JSONSerializer;

public class JsonConverterUtil {
	/*
	 * public static String orderToJson(List<Orders> list) { return new
	 * JSONSerializer().exclude("*.class", "*.part",
	 * "*.directlyAccessible").serialize(list); }
	 */

	public static JsonArray stockListToJson(List<Stock> list) {
		String str = new JSONSerializer().exclude("*.class", "*.directlyAccessible").serialize(list);
		JsonParser parser = new JsonParser();
		JsonElement tradeElement = parser.parse(str);
		JsonArray trade = tradeElement.getAsJsonArray();
		return trade;
	}

	public static JsonObject stockToJson(Stock list) {
		String str = new JSONSerializer().exclude("*.class", "*.directlyAccessible").serialize(list);
		JsonParser parser = new JsonParser();
		JsonElement tradeElement = parser.parse(str);
		JsonObject trade = tradeElement.getAsJsonObject();
		return trade;
	}

	public static Stock jsonToStock(String list) {
		return new Gson().fromJson(list, Stock.class);
		// return new JSONDeserializer<Stock>().deserialize(list);
	}

	public static JsonArray orderListToJson(List<Orders> list) {
		String str = new JSONSerializer().exclude("*.class", "*.part", "*.directlyAccessible").serialize(list);
//		String od = new JSONSerializer().serialize(list.get(0).getOrderItems());
		System.out.println("Order -----------------------------" + str);
		JsonParser parser = new JsonParser();
		JsonElement tradeElement = parser.parse(str);
		JsonArray trade = tradeElement.getAsJsonArray();
		JsonArray demo = new JsonArray();

		for (int i = 0; i < list.size(); i++) {
			JsonArray orderItem =  new JsonArray();
			for (int j = 0; j < list.get(i).getOrderItems().size(); j++) {
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("part_number", list.get(i).getOrderItems().get(j).getPart().getPartNumber());
				jsonObject.addProperty("line_total", list.get(i).getOrderItems().get(j).getLineTotal());
				jsonObject.addProperty("order_quantity", list.get(i).getOrderItems().get(j).getPartQuantity());
				jsonObject.addProperty("part_discription", list.get(i).getOrderItems().get(j).getPart().getDescription());
				jsonObject.addProperty("part_mrp", list.get(i).getOrderItems().get(j).getPart().getPartMRP());
				orderItem.add(jsonObject);
			}
			JsonObject order =  trade.get(i).getAsJsonObject();
			order.add("order_details", orderItem);
			demo.add(order);		
			
		}

		return demo;
	}
	
	public static JsonArray invoiceListToJson(List<Invoice> list) {
		JsonArray array =  new JsonArray();
		
		for (int i = 0; i < list.size(); i++) {
			
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("id", list.get(i).getId());
			jsonObject.addProperty("invoice_id", list.get(i).getInvoiceId());
			
			jsonObject.addProperty("invoice_date", list.get(i).getDate());
			jsonObject.addProperty("invoice_amount", list.get(i).getInvoiceAmount());
			jsonObject.addProperty("paid_amount", list.get(i).getPaidAmount());
			jsonObject.addProperty("retailer_code", list.get(i).getRetailer().getCode());
			jsonObject.addProperty("retailer_name", list.get(i).getRetailer().getName());
			
			array.add(jsonObject);
			
//			jsonObject.addProperty("invoice_id", list.get(i).getInvoiceId());
//			jsonObject.addProperty("invoice_id", list.get(i).getInvoiceId());
//			jsonObject.addProperty("invoice_id", list.get(i).getInvoiceId());
//			
		}
//		String str = new JSONSerializer().exclude("*.class", "*.part", "*.directlyAccessible").serialize(list);
//		System.out.println("Invoice -----------------------------" + str);
//		JsonParser parser = new JsonParser();
//		JsonElement tradeElement = parser.parse(str);
//		JsonArray trade = tradeElement.getAsJsonArray();
		return array;
	}

	
	public static JsonArray productListToJson(List<Product> list) throws ParseException {
		JsonArray array =  new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("id", list.get(i).getId());
			jsonObject.addProperty("part_number", list.get(i).getPartNumber());			
			jsonObject.addProperty("part_name", list.get(i).getDescription());
			jsonObject.addProperty("last_sync", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()).toString());
			jsonObject.addProperty("mrp", list.get(i).getPartMRP());
			jsonObject.addProperty("category", list.get(i).getCategory().getName());
			jsonObject.addProperty("applicable_model", list.get(i).getApplicableModel());
			jsonObject.addProperty("hsn", "");
			array.add(jsonObject);
		}
		return array;
	} 

	public static JsonArray retailerListToJson(List<Retailer> list) {
		String str = new JSONSerializer().exclude("*.class", "*.part", "*.directlyAccessible").serialize(list);
		System.out.println("Retailer ---------- : " + str);
		JsonParser parser = new JsonParser();
		JsonElement tradeElement = parser.parse(str);
		JsonArray trade = tradeElement.getAsJsonArray();		
		return trade;
	}

	public static String orderListToString(List<Orders> list) {
		String str = new JSONSerializer().exclude("*.class", "*.part", "*.directlyAccessible").include("orderItems")
				.serialize(list);
		// JsonParser parser = new JsonParser();
		// JsonElement tradeElement = parser.parse(str);
		// JsonArray trade = tradeElement.getAsJsonArray();
		return str;
	}
	
	public static JsonArray stockListToString(List<Stock> list) {
		String str = new JSONSerializer().exclude("*.class", "*.part", "*.directlyAccessible").include("orderItems")
				.serialize(list);
		JsonParser parser = new JsonParser();
		JsonElement tradeElement = parser.parse(str);
		JsonArray trade = tradeElement.getAsJsonArray();		
		return trade;
	}

}
