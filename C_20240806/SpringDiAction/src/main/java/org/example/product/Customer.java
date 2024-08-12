package org.example.product;

public class Customer {
    private String name;
    private ShoppingCart shoppingCart;

    public Customer(String name, ShoppingCart shoppingCart) {
        this.name = name;
        this.shoppingCart = shoppingCart;
    }

    public void addProductToCart(Product product) {
        shoppingCart.addProduct(product);
    }

    public void checkout() {
        System.out.println("Customer: " + name);
        shoppingCart.displayProducts();
        System.out.println("Total Price: " + shoppingCart.calculateTotal());
    }
}
