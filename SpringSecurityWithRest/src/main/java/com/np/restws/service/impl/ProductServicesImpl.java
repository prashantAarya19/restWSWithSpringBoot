package com.np.restws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.np.restws.model.Product;
import com.np.restws.service.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices {

	private List<Product> products = new ArrayList<>();
	private static Long id = 101l;
		
	public ProductServicesImpl() {
		Product product = new Product();
		product.setId(++id);
		product.setDescription("War is about to Start");
		products.add(product);
	}
	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public Long addProduct(Product product) {
		product.setId(++id);
		products.add(product);
		return product.getId();
	}

}
