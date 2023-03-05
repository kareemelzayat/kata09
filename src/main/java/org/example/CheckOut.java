package org.example;

import java.util.*;

public class CheckOut implements ICheckOut {

    private final Map<String, Integer> itemsCount;

    private final List<IPriceRule> priceRules;

    public CheckOut() {
        this.itemsCount = new HashMap<>();
        this.priceRules = new ArrayList<>();
    }

    public CheckOut(List<IPriceRule> priceRules) {
        this.itemsCount = new HashMap<>();
        this.priceRules = priceRules;
    }

    public void scan(String itemIdentifier) {
        if (itemsCount.containsKey(itemIdentifier)) {
            int current = itemsCount.get(itemIdentifier);
            itemsCount.put(itemIdentifier, current + 1);
            return;
        }
        itemsCount.put(itemIdentifier, 1);
    }

    public int getTotal() {
        if (priceRules.isEmpty()) {
            System.err.println("No price rules were defined!");
            return 0;
        }

        return priceRules.stream().mapToInt( priceRule -> {
            String itemIdentifier = priceRule.getItemIdentifier();
            boolean itemWasScanned = itemsCount.containsKey(itemIdentifier);
            if (itemWasScanned) {
                Integer itemQuantity = itemsCount.get(itemIdentifier);
                return priceRule.calculatePrice(itemQuantity);
            }
            return 0;
        }).sum();
    }
}
