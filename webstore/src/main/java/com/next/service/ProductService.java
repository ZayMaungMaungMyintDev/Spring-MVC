package com.next.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.next.domain.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product getProductById(String productID);

	List<Product> getProductByCategory(String category);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	List<Product> getProductsByManufacturer(String manufacturer);
	
	Set<Product> getProductsByPrice(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);

}
