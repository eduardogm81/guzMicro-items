package com.micros.items.controllers;

import com.micros.items.models.Item;
import com.micros.items.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
// @RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    public ItemController(@Qualifier("itemServiceWebClient")ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> list() {
        return itemService.fidnAll();
    }

    @GetMapping("/{id}")
    public Item details(@PathVariable Long id) {
        return itemService.findbyId(id);
    }

}
