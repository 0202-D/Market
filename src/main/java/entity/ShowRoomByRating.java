package entity;

import dao.Storage;

/**
 * @author Dm.Petrov
 * DATE: 30.08.2022
 */
public interface ShowRoomByRating {
    void showByRating(Storage storage, int rating);
}
