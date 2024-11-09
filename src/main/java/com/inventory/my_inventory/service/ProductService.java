package com.inventory.my_inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.my_inventory.entity.Product;
import com.inventory.my_inventory.exception.ResourceNotFoundException;
import com.inventory.my_inventory.repository.ProductRepository;

@Service
public class ProductService {
	 @Autowired
	    private ProductRepository productRepository;

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }
	    public Product addProduct(Product product) {
	        return productRepository.save(product);
	    }
	    public Product updateQuantity(Long id, int newQuantity) {
	        Optional<Product> optionalProduct = productRepository.findById(id);
	        if (optionalProduct.isPresent()) {
	            Product product = optionalProduct.get();
	            product.setQuantity(newQuantity);
	            return productRepository.save(product);  // Save the updated product and return it
	        } else {
	            throw new RuntimeException("Product not found with id: " + id);
	        }
	
	    }
	    
	    public Product getProductById(Long id) {
	        return productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	    }
	    
	    public void saveProduct(Product product) {
	        productRepository.save(product);
	    }
	    
	    
	    public void deleteProductById(Long id) {
	        productRepository.deleteById(id);
	    }
	    
	    public Product updateProduct(Long id, Product newProductData) {
	        return productRepository.findById(id).map(existingProduct -> {
	            existingProduct.setName(newProductData.getName());
	            existingProduct.setDescription(newProductData.getDescription());
	            existingProduct.setQuantity(newProductData.getQuantity());
	            return productRepository.save(existingProduct);
	        }).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

	    }

}