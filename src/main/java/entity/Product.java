package entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author Dm.Petrov
 * DATE: 30.08.2022
 */
@Getter
@Setter
public class Product {
    private int id;
    private String category;
    private String brand;
    private int price;
    private int rating;

    public Product(int id, String category, String brand, int price, int rating) {
        this.id = id;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getPrice() == product.getPrice() && getRating() == product.getRating() && Objects.equals(getId(), product.getId()) && Objects.equals(getCategory(), product.getCategory()) && Objects.equals(getBrand(), product.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategory(), getBrand(), getPrice(), getRating());
    }
}
