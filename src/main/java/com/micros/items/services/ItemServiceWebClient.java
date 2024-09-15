package com.micros.items.services;

import com.micros.items.models.Item;
import com.micros.items.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Primary
@Service
@RequiredArgsConstructor
public class ItemServiceWebClient implements ItemService{

    private final WebClient.Builder client;

    @Override
    public List<Item> fidnAll() {
        return this.client.build()
                .get()
                // .uri("http://product-service/api/products")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Product.class)
                .map(product -> new Item(product, getQuantity()))
                .collectList()
                .block();
    }

    @Override
    public Item findbyId(Long id) {
        Map<String, Object> params = Map.of("id", id);

        return this.client.build()
                .get()
                .uri("/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Product.class)
                .map(product -> new Item(product, getQuantity()))
                .block();
    }

    private static int getQuantity() {
        return (new Random()).nextInt(10) + 1;
    }
}
