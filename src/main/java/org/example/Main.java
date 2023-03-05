package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IPriceRule> priceRules = new ArrayList<>();
        priceRules.add(new PriceRule("A", 10, 3, 5));
        priceRules.add(new PriceRule("B", 9, 3, 2));
        priceRules.add(new PriceRule("C", 8, 3, 3));
        priceRules.add(new PriceRule("X", 2, 3, 4));
        priceRules.add(new PriceRule("Z", 1, 3, 0));

        ICheckOut checkOut = new CheckOut(priceRules);
        checkOut.scan("Z");
        checkOut.scan("Z");
        checkOut.scan("Z");
        checkOut.scan("A");
        checkOut.scan("A");
        checkOut.scan("A");
        System.out.println("Please pay: " + checkOut.getTotal());

        ICheckOut checkOutError = new CheckOut();
        checkOutError.scan("A");
        checkOutError.getTotal();
    }
}