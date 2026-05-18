package shop.promotion;

import shop.cart.ShoppingCart;
import shop.model.Product;

public class PercentPromotion implements Promotion {

    @Override
    public void apply(ShoppingCart cart) {

        if (cart.calculateTotalPrice() > 300) {
            for (Product product : cart.getProducts()) {
                Product newProduct =
                        product.withDiscountPrice(product.getDiscountPrice() * 0.95);
                cart.replaceProduct(product, newProduct);
            }
        }
    }

    @Override
    public String getName() {
        return "5 percent discount over 300";
    }
}