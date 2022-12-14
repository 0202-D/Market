package entity;

import dao.SimpleStorage;
import dao.Storage;

import java.util.Scanner;


/**
 * @author Dm.Petrov
 * DATE: 31.08.2022
 */
public class SimpleMarket extends Market {
    private final Scanner sc = new Scanner(System.in);
    private final Storage storage = new SimpleStorage();
    private final Basket basket = new Basket();
    private final ShowRoom showRoom = new ShowRoom();
    private boolean purchaseCompleted;

    public SimpleMarket() {
        startTrading();
    }

    @Override
    void startTrading() {
        System.out.println("Hello,welcome!!!");
        while (true) {
            int choice;
            System.out.println("ShowRoom - 1");
            System.out.println("put in basket - 2");
            System.out.println("buy - 3");
            System.out.println("exit - 0");
            choice = getChoice();
            if (choice == 0) {
                System.out.println("GoodBye");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("ShowAllProducts - 1");
                    System.out.println("Show products limited by rating - 2");
                    System.out.println("Show products limited by price - 3");
                    choice = getChoice();
                    switch (choice) {
                        case 1:
                            storage.showProducts();
                            break;
                        case 2:
                            System.out.println("Enter the lower limit of the rating ");
                            choice = getChoice();
                            showRoom.showByRating(storage, choice);
                            break;
                        case 3:
                            System.out.println("Enter the upper limit of the price ");
                            choice = getChoice();
                            showRoom.showByPrice(storage, choice);
                            break;
                        default:
                            System.out.println("No such this feature");
                    }
                    System.out.println("*********************************************************8");
                    break;
                case 2:
                    System.out.println("enter product id  ");
                    choice = getChoice();
                    System.out.println("enter product quantity  ");
                    int quantity = getChoice();
                    basket.put(storage.getProductById(choice), quantity);
                    break;
                case 3:
                    System.out.println(" Your basket :");
                    basket.showProducts();
                    System.out.println("You need to pay : " + basket.countSum()+" rub");
                    purchaseCompleted = true;
                    break;
                default:
                    System.out.println("No such this feature");
            }
            if (purchaseCompleted) {
                System.out.println("Thank you ... You will receive a link to the payment . Pay within 40 minutes, goodbye");
                break;
            }

        }
    }

    private int getChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (RuntimeException e) {
            System.out.println("Wrong input");
        }
        return choice;
    }
}
