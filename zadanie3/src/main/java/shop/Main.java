package shop;

import shop.cart.ShoppingCart;
import shop.model.Product;

public class Main {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        Product p1 = new Product("P1", "Keyboard", 150);
        Product p2 = new Product("P2", "Mouse", 100);
        Product p3 = new Product("P3", "Monitor", 400);

        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);


        for(Product product : cart.getProducts()) {
            System.out.println(product);
        }

        System.out.println(
                "Total = " + cart.calculateTotalPrice()
        );
    }
}