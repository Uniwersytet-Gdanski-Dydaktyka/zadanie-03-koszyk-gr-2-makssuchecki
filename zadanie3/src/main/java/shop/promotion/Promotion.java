package shop.promotion;

import shop.cart.ShoppingCart;

public interface Promotion {

    void apply(ShoppingCart cart);

    String getName();
}