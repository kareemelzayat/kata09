package org.example;

public class PriceRule implements IPriceRule {

    public PriceRule(String itemIdentifier, Integer price) {
        this.item = new Item(itemIdentifier, price);
        this.specialPrice = null;
    }

    public PriceRule(String itemIdentifier, Integer price, Integer quantity, Integer specialPrice) {
        this.specialPrice = new SpecialPrice(quantity, specialPrice);
        this.item = new Item(itemIdentifier, price, this.specialPrice);
    }

    private final Item item;

    private final SpecialPrice specialPrice;

    public String getItemIdentifier() {
        return item.getIdentifier();
    }

    public int calculatePrice(Integer itemQuantity) {
        Integer itemPrice = item.getPrice();
        if (specialPrice != null) {
            Integer specialPriceQuantity = specialPrice.getQuantity();
            Integer specialPricePrice = specialPrice.getPrice();
            if (itemQuantity >= specialPriceQuantity) {
                int quotient = Math.floorDiv(itemQuantity, specialPriceQuantity);
                int modulo = itemQuantity % specialPriceQuantity;
                return quotient * specialPricePrice + modulo * itemPrice;
            }
        }
        return itemPrice * itemQuantity;
    }
}
