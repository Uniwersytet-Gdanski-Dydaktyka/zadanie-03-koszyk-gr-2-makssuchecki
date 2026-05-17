package shop.promotion;

import shop.cart.ShoppingCart;
import shop.model.Product;

public class CouponPromotion implements Promotion {
    private final String productCode;
    public CouponPromotion(String productCode) {
        this.productCode = productCode;
    }
    @Override
    public void apply(ShoppingCart cart) {
        for (Product product : cart.getProducts()) {
            if (product.getCode().equals(productCode)) {
                Product newProduct =
                        product.withDiscountPrice(product.getDiscountPrice() * 0.7);

                cart.replaceProduct(product, newProduct);
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "30 percent coupon";
    }
}