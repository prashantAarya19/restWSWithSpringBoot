package com.np.restws.dao;

import java.util.List;

import com.np.restws.model.Product;

public interface ProductDAO {
	public String addProdcut(Product product);
	public Product updateProduct(Product product);
	public Product findProduct(Product product);
	public List<Product> findAllProduct();
	public boolean deleteProduct(int Product);
}
