package shop;

import org.junit.jupiter.api.Test;
import shop.cart.ShoppingCart;
import shop.model.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    public void shouldCalculateTotalPrice() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("1", "A", 100));
        cart.addProduct(new Product("2", "B", 200));

        assertEquals(
                300,
                cart.calculateTotalPrice()
        );
    }

    @Test
    public void shouldReturnZeroForEmptyCart() {

        ShoppingCart cart = new ShoppingCart();

        assertEquals(
                0,
                cart.calculateTotalPrice()
        );
    }
}