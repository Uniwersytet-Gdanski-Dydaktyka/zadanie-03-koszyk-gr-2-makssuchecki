package shop.comparator;

import shop.model.Product;

import java.util.Comparator;

public class PriceDescendingComparator implements Comparator<Product>{
    @Override
    public int compare(Product p1, Product p2){
        int result = Double.compare(p2.getPrice(), p1.getPrice());
        if (result == 0){
            return p1.getName().compareTo(p2.getName());
        }
        return result;
    }
}
