package shop;

import shop.cart.ShoppingCart;
import shop.model.Product;
import shop.comparator.PriceDescendingComparator;
import shop.promotion.*;
import shop.service.*;

public class Main {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        Product p1 = new Product("C1", "Speaker", 150);
        Product p2 = new Product("C2", "Keyboard", 200);
        Product p3 = new Product("C3", "Microphone", 400);

        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        System.out.println("Cheapest:");
        System.out.println(
                ProductFinder.findCheapest(cart.getProducts())
        );

        System.out.println();

        cart.sortProducts(new PriceDescendingComparator());

        System.out.println("Sorted: ");

        for(Product product : cart.getProducts()){
            System.out.println(product);
        }

        PromotionService service = new PromotionService();

        service.addPromotion(new PercentPromotion());
        service.addPromotion(new BuyTwoGetOnePromotion());
        service.addPromotion(new CouponPromotion("P3"));
        service.addPromotion(new FreeMugPromotion());

        service.applyPromotions(cart);

        System.out.println();
        System.out.println("After promotions:");

        for (Product product : cart.getProducts()){
            System.out.println(product);
        }
        System.out.println();
        System.out.println("TOTAL = " + cart.calculateTotalPrice());
    }
}