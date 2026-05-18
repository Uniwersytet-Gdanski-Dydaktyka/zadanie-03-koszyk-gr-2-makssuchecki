package shop.promotion;

import shop.cart.ShoppingCart;
import shop.model.Product;

import java.util.Comparator;
import java.util.List;

public class BuyTwoGetOnePromotion implements Promotion {

    @Override
    public void apply(ShoppingCart cart) {

        List<Product> products = cart.getProducts();

        int freeItems = products.size() / 3;

        if (freeItems == 0){
            return;
        }

        List<Product> sorted = products.stream()
                .sorted(Comparator.comparing(Product::getDiscountPrice))
                .toList();
        for (int i = 0; i<freeItems; i++){
            Product cheapest = sorted.get(i);
            Product discounted = cheapest.withDiscountPrice(0);
            cart.replaceProduct(cheapest, discounted);
        }
    }

    @Override
    public String getName() {
        return "Buy 2 get 1";
    }
}