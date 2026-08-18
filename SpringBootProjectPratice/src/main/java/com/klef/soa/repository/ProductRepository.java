package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.klef.soa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}