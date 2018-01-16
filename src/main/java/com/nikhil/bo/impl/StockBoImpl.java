package com.nikhil.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikhil.bo.StockBo;
import com.nikhil.dao.StockDao;
import com.nikhil.model.Stock;

@Repository("stockBo")
public class StockBoImpl implements StockBo {

	@Autowired
	StockDao stockDao;


	public List<Stock> distributorStock(String dsrCode) {
		return stockDao.distributorStock(dsrCode);
	}
}