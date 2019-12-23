package com.np.restws.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.np.restws.model.Product;

@Path("/productserviceporvider")
public interface ProductServices {
	
	@GET
	@Path("/products")
	public List<Product> getProducts();
	
	@POST
	@Path("/product")
	public Long addProduct(Product product);
}
