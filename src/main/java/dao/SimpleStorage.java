package dao;

import entity.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Dm.Petrov
 * DATE: 30.08.2022
 */
public class SimpleStorage implements Storage {
    private final Map<Product, Integer> storage = new HashMap<>();

    public SimpleStorage() {
        storage.put(new Product(1, "Device", "Redmi", 10000, 3), 3);
        storage.put(new Product(2, "Device", "Samsung", 15000, 5), 2);
        storage.put(new Product(3, "Device", "Prestigio", 3000, 2), 10);
    }

    public void put(Product product) {
        if (storage.containsKey(product)) {
            storage.put(product, storage.get(product) + 1);
        } else {
            storage.put(product, 1);
        }
    }

    public void delete(Product product) {
        if (storage.containsKey(product)) {
            if (storage.get(product) > 0) {
                storage.put(product, storage.get(product) - 1);
            }
        } else {
            System.out.println("There is no such product in stock");
        }
    }

    public Map<Product, Integer> getAllProducts() {
        return storage;
    }

    public void showProducts() {
        for (Map.Entry<Product, Integer> entry : storage.entrySet()
        ) {
            System.out.println(entry.getKey() + " Quantity - " + entry.getValue());
        }
    }

    public Product getProductById(int id) {
        Product product;
        List<Product> list = storage.keySet().stream().filter(el -> el.getId() == id).collect(Collectors.toList());
        if (!list.isEmpty()) {
            product = list.get(0);
            return product;
        }
        return new Product(0, "null", "null", 0, 0);
    }


}

