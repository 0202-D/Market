package entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dm.Petrov
 * DATE: 31.08.2022
 */
public class Basket {
    static private final Map<Product, Integer> basket = new HashMap<>();

    public void put(Product product, int quantity) {
        if (basket.containsKey(product)) {
            basket.put(product, basket.get(product) + quantity);
        } else {
            basket.put(product, quantity);
        }
    }

    public void delete(Product product) {
        if (basket.containsKey(product)) {
            if (basket.get(product) > 0) {
                basket.put(product, basket.get(product) - 1);
            }
        } else {
            System.out.println("There is no such product in stock");
        }
    }

    public Map<Product, Integer> getAllProducts() {
        return basket;
    }

    public void showProducts() {
        for (Map.Entry<Product, Integer> entry : basket.entrySet()
        ) {
            System.out.println(entry.getKey() + "Quantity : " + entry.getValue());
        }
    }

    public int countSum() {
        int sum = 0;
        for (Map.Entry<Product, Integer> entry : basket.entrySet()
        ) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

}
