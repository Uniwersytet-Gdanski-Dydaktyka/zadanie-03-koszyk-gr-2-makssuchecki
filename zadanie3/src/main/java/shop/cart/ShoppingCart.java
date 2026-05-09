package shop.cart;

import shop.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    private final List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {

        if(product == null) {
            throw new IllegalArgumentException("Product can't be null");
        }

        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public double calculateTotalPrice() {

        double sum = 0;

        for(Product product : products) {
            sum += product.getDiscountPrice();
        }

        return sum;
    }

    public void resetDiscounts() {

        for(Product product : products) {
            product.resetDiscountPrice();
        }
    }

    public void sortProducts(java.util.Comparator<Product> comparator) {
        Collections.sort(products, comparator);
    }
}