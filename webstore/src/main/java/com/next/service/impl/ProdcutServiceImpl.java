package com.next.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.domain.Product;
import com.next.repository.ProductRepository;
import com.next.service.ProductService;

@Service
public class ProdcutServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(String productID) {
		return productRepository.getProductId(productID);
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProoductsByFilter(filterParams);
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		return productRepository.getProductsByManufacturer(manufacturer);
	}

	@Override
	public Set<Product> getProductsByPrice(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByPrice(filterParams);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

}
