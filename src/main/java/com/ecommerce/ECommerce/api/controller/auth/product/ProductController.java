package com.ecommerce.ECommerce.api.controller.auth.product;

import com.ecommerce.ECommerce.model.Product;
import com.ecommerce.ECommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
