package com.nikhil.bo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nikhil.model.Retailer;

@Repository
public interface RetailerBo {

	Retailer retailerFromId(String retailerCode);

	List<Retailer> dsrRetailerList(String dsrCode);
}
