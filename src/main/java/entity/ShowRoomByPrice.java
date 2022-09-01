package entity;

import dao.Storage;

/**
 * @author Dm.Petrov
 * DATE: 30.08.2022
 */
public interface ShowRoomByPrice {
    void showByPrice(Storage storage, int price);
}
