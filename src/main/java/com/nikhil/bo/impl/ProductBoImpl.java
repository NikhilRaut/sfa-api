package com.nikhil.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikhil.bo.ProductBo;
import com.nikhil.dao.ProductDao;
import com.nikhil.model.Product;

@Repository("productBo")
public class ProductBoImpl implements ProductBo{
	@Autowired
	ProductDao dao;

	public List<Product> product(String lastSync, int offSet, int limit) {
		return dao.product(lastSync, offSet, limit);
	}

	public List<Product> product(int offSet, int limit) {
		return dao.product(offSet, limit);
	}

	public List<Product> product() {
		return dao.product();
	}

	public List<Product> product(String lastSync) {
		return dao.product(lastSync);
	}

}
