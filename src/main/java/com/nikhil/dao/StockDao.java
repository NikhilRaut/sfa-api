package com.nikhil.dao;

import java.util.List;

import com.nikhil.model.Stock;

public interface StockDao {

	List<Stock> distributorStock(String dsrCode);
}
