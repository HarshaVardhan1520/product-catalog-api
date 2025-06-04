package com.example.productcatalog.service;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.repository.ProductRepository;
import com.example.productcatalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductId(id);
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow();
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> filterByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    public List<Product> filterByPriceRange(double min, double max) {
        return productRepo.findByPriceBetween(min, max);
    }

    public List<Product> searchByName(String keyword) {
        return productRepo.findByNameContainingIgnoreCase(keyword);
    }
}
