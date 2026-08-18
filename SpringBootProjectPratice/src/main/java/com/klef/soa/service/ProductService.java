package com.klef.soa.service;

import com.klef.soa.entity.Product;

public interface ProductService {
Product addproduct(Product p);
Product updatestock(Product p);
Product deleteProduct();
Product findbycategory(int id);
Product findbypricerange(int price);
Product sortbyprice();
Product searchbyname(String name);
}
