package entity;


import dao.Storage;

/**
 * @author Dm.Petrov
 * DATE: 31.08.2022
 */
public class Market {
    private Basket basket;
    private Storage storage;

    void startTrading() {
        System.out.println("Market started ...");
    }


}
