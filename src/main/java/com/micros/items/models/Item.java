package com.micros.items.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Product product;
    private int quantity;

    public Double getTotal() {
        return product != null ? product.getPrice() * quantity : 0d;
    }
}
