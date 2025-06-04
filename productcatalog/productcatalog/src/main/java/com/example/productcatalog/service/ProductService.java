package com.example.productcatalog.service;

import com.example.productcatalog.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> filterByCategory(String category);
    List<Product> filterByPriceRange(double min, double max);
    List<Product> searchByName(String keyword);
}
