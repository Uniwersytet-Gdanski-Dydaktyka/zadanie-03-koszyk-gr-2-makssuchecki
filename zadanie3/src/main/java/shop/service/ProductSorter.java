package shop.service;

import shop.model.Product;

import java.util.Comparator;
import java.util.List;

public class ProductSorter {
    public static void sortProducts(List<Product> products, Comparator<Product> comparator){
        products.sort(comparator);
    }
}
