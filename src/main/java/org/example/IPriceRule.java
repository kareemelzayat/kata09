package org.example;

public interface IPriceRule {
    int calculatePrice(Integer itemQuantity);

    String getItemIdentifier();
}
