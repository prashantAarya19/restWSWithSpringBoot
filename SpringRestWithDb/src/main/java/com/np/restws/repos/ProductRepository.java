package com.np.restws.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.restws.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
