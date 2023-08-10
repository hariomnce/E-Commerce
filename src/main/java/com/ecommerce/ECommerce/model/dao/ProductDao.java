package com.ecommerce.ECommerce.model.dao;

import com.ecommerce.ECommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
