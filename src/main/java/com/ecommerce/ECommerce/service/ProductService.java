package com.ecommerce.ECommerce.service;

import com.ecommerce.ECommerce.model.Product;
import com.ecommerce.ECommerce.model.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProducts() {
        return productDao.findAll();
    }
}
