package com.inventory.my_inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.my_inventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
