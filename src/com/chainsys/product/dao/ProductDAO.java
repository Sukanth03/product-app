package com.chainsys.product.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();

	Product findById(int id);

	void save(Product product);

	void update(Product product);

	void delete(int id);

	Product findByName(String name);
	
	void update_expire(Product product);
	
	List<String> findAllName();
	
	Product findByDate(LocalDate expiryDate);

	void delete_name(String name);

	void delete_id(int id);

	List<Integer> findAllId();

}
