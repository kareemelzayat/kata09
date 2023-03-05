package org.example;

public class Item {

    public Item(String identifier, int price) {
        this.identifier = identifier;
        this.price = price;
    }

    public Item(String identifier, int price, SpecialPrice specialPrice) {
        this.identifier = identifier;
        this.price = price;
        this.specialPrice = specialPrice;
    }

    private final String identifier;

    private final Integer price;

    private SpecialPrice specialPrice;

    public String getIdentifier() {
        return identifier;
    }

    public Integer getPrice() {
        return price;
    }

    public SpecialPrice getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(SpecialPrice specialPrice) {
        this.specialPrice = specialPrice;
    }

    public boolean hasSpecialPrice() {
        return specialPrice != null;
    }
}
