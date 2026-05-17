package shop.promotion;

import shop.cart.ShoppingCart;
import shop.model.Product;

public class FreeMugPromotion implements Promotion {
    @Override
    public void apply(ShoppingCart cart){
        if (cart.calculateTotalPrice() > 200) {
            Product mug = new Product(
                    "FREE_MUG",
                    "Company Mug",
                    0
            );
            cart.addProduct(mug);
        }
    }
    @Override
    public String getName(){
        return "Free mug";
    }
}
