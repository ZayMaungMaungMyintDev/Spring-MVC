package com.next.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.next.domain.Product;

public interface ProductRepository {
	
	List<Product> getAllProducts();
	
	Product getProductId(String productID);
	
	List<Product> getProductsByCategory(String category);
	
	Set<Product> getProoductsByFilter(Map<String, List<String>> filterParams);
	
	List<Product> getProductsByManufacturer(String manufacturer);
	
	Set<Product> getProductsByPrice(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);

}
