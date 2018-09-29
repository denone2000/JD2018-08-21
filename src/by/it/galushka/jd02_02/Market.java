package by.it.galushka.jd02_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Market {

    private static int counterBuyers = 0;
    private static List<Buyer> buyers = new ArrayList<>();
    private static List<Thread> threads = new ArrayList<>();


    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Чтобы продолжить нужно выбрать скорость работы программы:\n" +
                "для ускорения работы программы нужно ввести \"fast\";\n" +
                "для работы в обычном режиме нужно ввести \"norm\".\n" +
                "Если ввести что-то иное, программа прекратит свою работу.");
        String input = scanner.nextLine();
        switch (input) {
            case "fast":
                Dispatcher.setXspeed(100);
                break;
            case "norm":
                Dispatcher.setXspeed(1);
                break;
            default:
                System.out.println("Вы ввели неверное значение!\n" +
                        "Для работы программы нужно выбрать режим: \"fast\" или \"norm\"!");
                return;
        }

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }

        while (Dispatcher.marketIsOpened()) {
            for (int i = 0; i < 2; i++) {
                if (Dispatcher.marketIsOpened()) {
                    newBuyer();
                    Util.sleep(100);
                }
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total buyers in market: " + Dispatcher.getBuyersInMarket());
        System.out.println("Market is closed.");
    }

    private static void newBuyer() {
        Buyer buyer = new Buyer(++counterBuyers);
        Buyer.pensioneer = counterBuyers % 4 == 0;
        buyers.add(buyer);
        buyer.start();
    }
}
