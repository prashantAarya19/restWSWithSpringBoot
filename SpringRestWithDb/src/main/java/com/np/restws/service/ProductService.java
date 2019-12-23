package com.np.restws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.np.restws.model.Product;

@Produces("application/json")
@Consumes("application/json")
@Path("/productservice")
public interface ProductService {
	

	@Path("/products")
	@GET
	public List<Product> getProducts();

	@Path("/product/{id}")
	@GET
	public Product getProduct(@PathParam("id") int id);

	@Path("/product")
	@POST
	public Response createProduct(Product product);

	@Path("/product")
	@PUT
	public Response updateProduct(Product product);

	@Path("/products/{id}")
	@DELETE
	public Response deleteProduct(@PathParam("id") int id);
}
