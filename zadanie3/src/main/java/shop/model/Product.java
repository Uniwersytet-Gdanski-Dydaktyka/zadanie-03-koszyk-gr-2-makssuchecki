package shop.model;

public class Product {

    private final String code;
    private final String name;
    private final double price;
    private final double discountPrice;

    public Product(String code, String name, double price) {
        this(code, name, price, price);
    }

    public Product(String code, String name, double price, double discountPrice) {

        if (code == null || name == null) {
            throw new IllegalArgumentException("Code and name cannot be null");
        }

        if (price < 0 || discountPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public Product withDiscountPrice(double newPrice) {
        return new Product(code, name, price, newPrice);
    }

    @Override
    public String toString() {
        return name + " price=" + price + " discountPrice=" + discountPrice;
    }
}