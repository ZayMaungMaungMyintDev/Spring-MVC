package com.next.repository;

import java.util.List;

import com.next.domain.Product;

public interface ProductRepository {
	
	List<Product> getAllProducts();
	
	Product getProductId(String productID);

}
