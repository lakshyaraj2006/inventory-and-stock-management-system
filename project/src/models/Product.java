package models;
import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // getters and setters
}