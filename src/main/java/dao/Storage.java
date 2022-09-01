package dao;

import entity.Product;

import java.util.Map;

public interface Storage {
    void put(Product product);

    void delete(Product prouct);

    void showProducts();

    Map<Product, Integer> getAllProducts();

    Product getProductById(int id);
}
