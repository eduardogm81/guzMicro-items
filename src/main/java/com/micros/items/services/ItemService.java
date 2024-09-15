package com.micros.items.services;

import com.micros.items.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> fidnAll();
    Item findbyId(Long id);
}
