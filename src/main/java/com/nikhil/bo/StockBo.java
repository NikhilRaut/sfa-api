package com.nikhil.bo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nikhil.model.Stock;

@Repository
public interface StockBo {

	List<Stock> distributorStock(String dsrCode);

}
