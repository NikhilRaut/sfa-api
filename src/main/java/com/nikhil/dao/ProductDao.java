package com.nikhil.dao;

import java.util.List;

import com.nikhil.model.Product;

public interface ProductDao {

	List<Product> product(String lastSync, int offSet, int limit);

	List<Product> product(int offSet, int limit);

	List<Product> product(String lastSync);

	List<Product> product();

}
