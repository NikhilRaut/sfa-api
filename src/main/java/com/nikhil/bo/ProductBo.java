package com.nikhil.bo;

import java.util.List;

import com.nikhil.model.Product;

public interface ProductBo {

	List<Product> product(String lastSync, int offSet, int limit);

	List<Product> product(int offSet, int limit);
	
	List<Product> product(String lastSync);

	List<Product> product();

}
