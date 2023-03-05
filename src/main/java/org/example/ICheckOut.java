package org.example;

public interface ICheckOut {
    void scan(String itemIdentifier);
    int getTotal();
}