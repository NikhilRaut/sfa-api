package com.nikhil.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikhil.bo.RetailerBo;
import com.nikhil.dao.RetailerDao;
import com.nikhil.model.Retailer;

@Repository("retailerBo")
public class RetailerBoImpl implements RetailerBo {

	@Autowired
	RetailerDao retailerDao;
	
	public Retailer retailerFromId(String retailerCode) {
		return retailerDao.retailerFromId(retailerCode);
	}

	public List<Retailer> dsrRetailerList(String dsrCode) {
		return retailerDao.dsrRetailerList(dsrCode);
	}

}
