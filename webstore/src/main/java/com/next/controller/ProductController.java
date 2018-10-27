package com.next.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.next.domain.Product;
import com.next.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	/*
	 * @RequestMapping("/all") public String allProducts(Model model) {
	 * model.addAttribute("products", productService.getAllProducts()); return
	 * "products"; }
	 */

	@RequestMapping("/all")
	public ModelAndView allProducts() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("products", productService.getAllProducts());
		modelAndView.setViewName("products");

		return modelAndView;
	}

	/*
	 * @RequestMapping("/{category}") public String getProductsByCategory(Model
	 * model, @PathVariable("category") String productCategory) {
	 * model.addAttribute("products",
	 * productService.getProductByCategory(productCategory)); return "products";
	 * 
	 * }
	 */

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";

	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping(value = "/{category}/{ByPrice}", method = RequestMethod.GET)
	public String filterProducts(@PathVariable("category") String productCategory,
			@MatrixVariable(pathVar = "ByPrice") Map<String, List<String>> filterPrice,
			@RequestParam("manufacturer") String manufacturer, Model model) {

		List<Product> productsListByCategory = new ArrayList<Product>();
		List<Product> productsListByManufacturer = new ArrayList<Product>();
		Set<Product> productListByPrice = new HashSet<Product>();

		productsListByCategory = this.getProductsByCategory(productCategory);
		productsListByManufacturer = this.getProductsByManufacturer(manufacturer);
		productListByPrice = productService.getProductsByPrice(filterPrice);

		if (productsListByCategory.size() > 0 && productsListByManufacturer.size() > 0
				&& productListByPrice.size() > 0) {
			model.addAttribute("products", productListByPrice);
		} else {
			model.addAttribute("products", productsListByCategory);
		}

		return "products";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct , BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields:	" 
		+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		productService.addProduct(newProduct);
		return "redirect:/products";
	}

	private List<Product> getProductsByCategory(String category) {
		return productService.getProductByCategory(category);
	}

	private List<Product> getProductsByManufacturer(String manufacturer) {
		return productService.getProductsByManufacturer(manufacturer);
	}

}
