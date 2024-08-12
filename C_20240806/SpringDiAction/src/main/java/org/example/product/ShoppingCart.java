package org.example.product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println("Product: " + product.getName() + ", Price: " + product.getPrice());
        }
    }
}

