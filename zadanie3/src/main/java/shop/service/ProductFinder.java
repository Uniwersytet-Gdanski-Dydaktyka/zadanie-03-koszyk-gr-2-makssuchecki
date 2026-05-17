package shop.service;

import shop.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductFinder {
    public static Product findCheapest(List<Product> products){
        return products.stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }
    public static Product findMostExpensive(List<Product> products){
        return products.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }
    public static List<Product> findNCheapest(List<Product> products,int n){
        return products.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(n)
                .collect(Collectors.toList());
    }
    public static List<Product> findNMostExpensive(List<Product> products, int n){
        return products.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }
}

