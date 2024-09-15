package com.micros.items.client;

import com.micros.items.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductFeignClient {

    @GetMapping("/api/products")
    List<Product> findAll();

    @GetMapping("/api/products/{id}")
    Product details(@PathVariable Long id);

}
