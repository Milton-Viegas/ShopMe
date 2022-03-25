package com.eu.shopme.ecommerce.service;

import com.eu.shopme.ecommerce.exception.ResourceNotFoundException;
import com.eu.shopme.ecommerce.model.Product;
import com.eu.shopme.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado!"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
