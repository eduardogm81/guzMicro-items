package com.micros.items.services;

import com.micros.items.client.ProductFeignClient;
import com.micros.items.models.Item;
import com.micros.items.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ProductFeignClient productFeignClient;

    public List<Item> fidnAll() {
        return productFeignClient.findAll()
                .stream().map(product -> new Item(product, getQuantity())).toList();
    }

    public Item findbyId(Long id) {
        Product details = productFeignClient.details(id);
        return new Item(details, getQuantity() );
    }

    private static int getQuantity() {
        return (new Random()).nextInt(10) + 1;
    }
 }
