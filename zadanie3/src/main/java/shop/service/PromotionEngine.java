package shop.service;

import shop.cart.ShoppingCart;
import shop.promotion.Promotion;

import java.util.ArrayList;
import java.util.List;

public class PromotionEngine {
    private final List<Promotion> promotions;

    public PromotionEngine(){
        promotions = new ArrayList<>();
    }

    public void addPromotion(Promotion promotion){
        promotions.add(promotion);
    }

    public void applyPromotions(ShoppingCart cart){
        for (Promotion promotion : promotions){
            promotion.apply(cart);
        }
    }
}
