package entity;


import dao.Storage;

public class ShowRoom implements ShowRoomByRating, ShowRoomByPrice {
    @Override
    public void showByRating(Storage storage, int rating) {
        storage.getAllProducts().entrySet().stream().filter(el -> el.getKey().getRating() >= rating)
                .forEach(el -> System.out.println(el.getKey() + "  Quantity in storage -" + el.getValue()));
    }

    @Override
    public void showByPrice(Storage storage, int price) {
        storage.getAllProducts().entrySet().stream().filter(el -> el.getKey().getPrice() >= price)
                .forEach(el -> System.out.println(el.getKey() + "  Quantity in storage -" + el.getValue()));
    }
}
