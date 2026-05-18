package shop;

import org.junit.jupiter.api.Test;
import shop.model.Product;
import shop.service.ProductFinder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductFinderTest {

    @Test
    public void shouldFindCheapest() {

        List<Product> products = List.of(
                new Product("1", "A", 100),
                new Product("2", "B", 50),
                new Product("3", "C", 200)
        );

        Product cheapest = ProductFinder.findCheapest(products);

        assertEquals("2", cheapest.getCode());
    }

    @Test
    public void shouldFindMostExpensive() {

        List<Product> products = List.of(
                new Product("1", "A", 100),
                new Product("2", "B", 50),
                new Product("3", "C", 200)
        );

        Product mostExpensive = ProductFinder.findMostExpensive(products);

        assertEquals("3", mostExpensive.getCode());
    }

    @Test
    public void shouldReturnNCheapest() {

        List<Product> products = List.of(
                new Product("1", "A", 100),
                new Product("2", "B", 50),
                new Product("3", "C", 200)
        );

        List<Product> result = ProductFinder.findNCheapest(products, 2);

        assertEquals(2, result.size());
        assertEquals("2", result.get(0).getCode());
    }
    @Test
    public void shouldReturnNMostExpensive() {

        List<Product> products = List.of(
                new Product("1", "A", 100),
                new Product("2", "B", 50),
                new Product("3", "C", 200)
        );

        List<Product> result = ProductFinder.findNMostExpensive(products, 2);

        assertEquals(2, result.size());
        assertEquals("3", result.get(0).getCode());
    }
}