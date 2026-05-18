package shop;

import org.junit.jupiter.api.Test;
import shop.comparator.PriceDescendingComparator;
import shop.comparator.NameComparator;
import shop.model.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {

    @Test
    public void shouldSortByPriceDescending() {

        List<Product> products = new ArrayList<>();

        products.add(new Product("1", "A", 100));
        products.add(new Product("2", "B", 200));
        products.add(new Product("3", "C", 50));

        products.sort(new PriceDescendingComparator());

        assertEquals("2", products.get(0).getCode());
        assertEquals("1", products.get(1).getCode());
        assertEquals("3", products.get(2).getCode());
    }

    @Test
    public void shouldSortAlphabeticallyWhenSamePrice() {

        List<Product> products = new ArrayList<>();

        products.add(new Product("1", "B", 100));
        products.add(new Product("2", "A", 100));

        products.sort(new PriceDescendingComparator());

        assertEquals("A", products.get(0).getName());
    }
    @Test
    public void shouldSortAlphabetically() {

        List<Product> products = new ArrayList<>();

        products.add(new Product("1", "B", 30));
        products.add(new Product("2", "A", 50));
        products.add(new Product("3", "C", 100));
        products.add(new Product("4", "D", 10));
        products.sort(new NameComparator());

        assertEquals("A", products.get(0).getName());
        assertEquals("C", products.get(2).getName());
    }

}