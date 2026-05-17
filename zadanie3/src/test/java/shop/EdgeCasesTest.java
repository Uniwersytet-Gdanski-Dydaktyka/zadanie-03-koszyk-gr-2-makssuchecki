package shop;

import org.junit.jupiter.api.Test;
import shop.cart.ShoppingCart;
import shop.model.Product;

import static org.junit.jupiter.api.Assertions.*;

public class EdgeCasesTest {

    @Test
    public void shouldHandleEmptyCart() {

        ShoppingCart cart = new ShoppingCart();

        assertEquals(0, cart.calculateTotalPrice());
    }

    @Test
    public void shouldHandleZeroPriceProduct() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("1", "Free", 0));

        assertEquals(0, cart.calculateTotalPrice());
    }

    @Test
    public void shouldThrowExceptionForNullProduct() {

        ShoppingCart cart = new ShoppingCart();

        assertThrows(IllegalArgumentException.class, () -> {
            cart.addProduct(null);
        });
    }
}