package org.example;

public class SpecialPrice {

    public SpecialPrice(Integer quantity, Integer price) {
        this.quantity = quantity;
        this.price = price;
    }

    private final Integer quantity;

    private final Integer price;

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPrice() {
        return price;
    }
}
