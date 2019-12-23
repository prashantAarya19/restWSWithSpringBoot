package com.np.restws.service.impl;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.restws.model.Product;
import com.np.restws.repos.ProductRepository;
import com.np.restws.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;

	@Override
	public List<Product> getProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProduct(int id) {
		return repository.findById(id).get();
	}

	public Response createProduct(Product product) {
		Product savedData = repository.save(product);
		return Response.ok(savedData).build();
	}

	@Override
	public Response updateProduct(Product product) {
		Product updatedData = repository.save(product);
		return Response.ok(updatedData).build();
	}

	@Override
	public Response deleteProduct(int id) {
		Product product = repository.getOne(id);
		if (product.getId() == id) {
			repository.deleteById(id);
			return Response.ok("Product Deleted").build();
		} else {
			return Response.ok("Product not found").build();
		}
	}

}
