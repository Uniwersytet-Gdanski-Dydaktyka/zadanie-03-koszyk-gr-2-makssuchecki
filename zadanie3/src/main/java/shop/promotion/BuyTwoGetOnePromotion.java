package shop.promotion;

import shop.cart.ShoppingCart;
import shop.model.Product;

import java.util.Comparator;
import java.util.List;

public class BuyTwoGetOnePromotion implements Promotion {

    @Override
    public void apply(ShoppingCart cart) {

        List<Product> products = cart.getProducts();

        if (products.size() < 3) {
            return;
        }

        products.stream()
                .min(Comparator.comparing(Product::getDiscountPrice))
                .ifPresent(cheapest -> {
                    Product newProduct = cheapest.withDiscountPrice(0);
                    cart.replaceProduct(cheapest, newProduct);
                });
    }

    @Override
    public String getName() {
        return "Buy 2 get 1";
    }
}