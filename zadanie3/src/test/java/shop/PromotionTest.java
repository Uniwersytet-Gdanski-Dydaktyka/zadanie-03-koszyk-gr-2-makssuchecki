package shop;

import org.junit.jupiter.api.Test;
import shop.cart.ShoppingCart;
import shop.model.Product;
import shop.promotion.*;
import shop.service.PromotionEngine;
import static org.junit.jupiter.api.Assertions.*;

public class PromotionTest {

    @Test
    public void shouldApplyPercentageDiscountOver300() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("1", "A", 200));
        cart.addProduct(new Product("2", "B", 150));

        new PercentPromotion().apply(cart);

        assertEquals(332.5, cart.calculateTotalPrice(), 0.01);
    }

    @Test
    public void shouldNotApplyPercentageDiscountBelow300() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("1", "A", 100));
        cart.addProduct(new Product("2", "B", 100));

        new PercentPromotion().apply(cart);

        assertEquals(200, cart.calculateTotalPrice());
    }

    @Test
    public void shouldApplyBuy2Get1() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("1", "A", 10));
        cart.addProduct(new Product("2", "B", 20));
        cart.addProduct(new Product("3", "C", 30));

        new BuyTwoGetOnePromotion().apply(cart);

        assertEquals(50, cart.calculateTotalPrice());
    }

    @Test
    public void shouldNotApplyBuy2Get1WhenLessThan3() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("1", "A", 10));
        cart.addProduct(new Product("2", "B", 20));

        new BuyTwoGetOnePromotion().apply(cart);

        assertEquals(30, cart.calculateTotalPrice());
    }

    @Test
    public void shouldApplyCoupon() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("1", "A", 100));
        cart.addProduct(new Product("2", "B", 100));

        new CouponPromotion("1").apply(cart);

        assertEquals(170, cart.calculateTotalPrice());
    }

    @Test
    public void shouldApplyFreeMug() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("1", "A", 150));
        cart.addProduct(new Product("2", "B", 100));

        new FreeMugPromotion().apply(cart);

        assertEquals(3, cart.getProducts().size());
    }

    @Test
    public void shouldApplyMultiplePromotionsTogether() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("1", "A", 200));
        cart.addProduct(new Product("2", "B", 150));
        cart.addProduct(new Product("3", "C", 50));

        PromotionEngine engine = new PromotionEngine();

        engine.addPromotion(new PercentPromotion());
        engine.addPromotion(new BuyTwoGetOnePromotion());

        engine.applyPromotions(cart);

        assertTrue(cart.calculateTotalPrice() < 400);
    }
}