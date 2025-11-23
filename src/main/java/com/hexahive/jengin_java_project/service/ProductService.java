package com.hexahive.jengin_java_project.service;


import com.hexahive.jengin_java_project.model.Product;
import com.hexahive.jengin_java_project.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product save(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product newProduct) {
        Optional<Product> existing = repo.findById(id);
        if (existing.isPresent()) {
            Product p = existing.get();
            p.setName(newProduct.getName());
            p.setPrice(newProduct.getPrice());
            p.setDescription(newProduct.getDescription());
            return repo.save(p);
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
