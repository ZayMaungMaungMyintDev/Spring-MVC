package com.next.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.next.domain.Product;
import com.next.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<Product>();

	public ProductRepositoryImpl() {
		Product iphone = new Product("P1234", "iPhone 5s", 500);
		iphone.setDescription(
				"Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and	8-megapixel rear camera");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);

		Product laptop_dell = new Product("P1235", "Dell Inspiron", 700);
		laptop_dell.setDescription("\"Dell Inspiron 14-inch	Laptop (Black) with 3rd Generation	Intel Core processors");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);

		Product tablet_Nexus = new Product("P1236", "Nexus 7", 300);
		tablet_Nexus.setDescription(
				"Google Nexus 7 is the lightest	7 inch tablet With a quad-core Qualcomm	Snapdragon™ S4 Pro processor");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);

		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
	}

	@Override
	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	@Override
	public Product getProductId(String productId) {
		Product productById = null;

		for (Product product : listOfProducts) {

			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}

		if (productById == null) {
			throw new IllegalArgumentException("No	products found with the product	id: " + productId);
		}
		return productById;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		List<Product> productByCategory = new ArrayList<Product>();

		for (Product product : listOfProducts) {
			if (category.equalsIgnoreCase(product.getCategory())) {
				productByCategory.add(product);
			}
		}
		return productByCategory;
	}

	@Override
	public Set<Product> getProoductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();

		Set<String> criterias = filterParams.keySet();

		if (criterias.contains("brand")) {
			for (String beandName : filterParams.get("brand")) {
				for (Product product : listOfProducts) {
					if (beandName.equalsIgnoreCase(product.getManufacturer())) {
						productsByBrand.add(product);
					}
				}
			}
		}

		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}

		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		List<Product> productListByMan = new ArrayList<Product>();
		for (Product product : listOfProducts) {
			if (manufacturer.equals(product.getManufacturer())) {
				productListByMan.add(product);
			}
		}
		return productListByMan;
	}

	@Override
	public Set<Product> getProductsByPrice(Map<String, List<String>> filterParams) {
		Set<Product> productsByPrice = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();

		if (criterias.contains("low") && criterias.contains("high")) {
			for (int i = 0; i < filterParams.size(); i++) {
				String low = filterParams.get("low").toString();
				low = low.replace("[", "");
				low = low.replace("]", "");

				String high = filterParams.get("high").toString();
				high = high.replace("[", "");
				high = high.replace("]", "");

				int intLow = Integer.parseInt(low);
				int intHigh = Integer.parseInt(high);
				for (Product product : listOfProducts) {

					if (product.getUnitPrice() >= intLow && product.getUnitPrice() <= intHigh) {
						productsByPrice.add(product);
					}
				}
			}
			return productsByPrice;
		} else {
			return null;
		}

	}

	@Override
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}

};