package com.nikhil.dao;

import java.util.List;

import com.nikhil.model.Retailer;

public interface RetailerDao {

	Retailer retailerFromId(String retailerCode);

	List<Retailer> dsrRetailerList(String dsrCode);
}
