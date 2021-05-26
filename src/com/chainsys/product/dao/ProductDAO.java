package com.chainsys.product.dao;

import java.time.LocalDate;
import java.util.Set;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();

	Product findById(int id);

	void save(Product product);

	void update(Product product);

	void delete(int id);
	
	Product findByName(String name);
	
	void updatedate(Product product);
	
	Product findByDate(LocalDate expiryDate);


}
