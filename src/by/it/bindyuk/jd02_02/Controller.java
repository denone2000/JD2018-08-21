package by.it.bindyuk.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Controller extends Thread {

    static List<Thread> threads = new ArrayList<>();
    static int counterBuyer = 0;

    @Override
    public void run() {
        Cashier cashier1 = new Cashier(1);
        Thread thread1 = new Thread(cashier1);

        Cashier cashier2 = new Cashier(2);
        Thread thread2 = new Thread(cashier2);

        Cashier cashier3 = new Cashier(3);
        Thread thread3 = new Thread(cashier3);

        Cashier cashier4 = new Cashier(4);
        Thread thread4 = new Thread(cashier4);

        Cashier cashier5 = new Cashier(5);
        Thread thread5 = new Thread(cashier5);

        while (Dispatcher.isMarketOpen()) {

            if (QueueBuyers.getSizeDeque() > 0 & QueueBuyers.getSizeDeque() < 6 & (thread1.getState() == State.NEW |
                    thread1.getState() == State.TERMINATED)) {
                thread1.start();
                threads.add(thread1);
            }
            if (QueueBuyers.getSizeDeque() >= 6 & QueueBuyers.getSizeDeque() < 11 & (thread2.getState() == State.NEW |
                    thread2.getState() == State.TERMINATED)) {
                thread2.start();
                threads.add(thread2);
            }
            if (QueueBuyers.getSizeDeque() >= 11 & QueueBuyers.getSizeDeque() < 16 & (thread3.getState() == State.NEW |
                    thread3.getState() == State.TERMINATED)) {
                thread3.start();
                threads.add(thread3);

            }
            if (QueueBuyers.getSizeDeque() >= 16 & QueueBuyers.getSizeDeque() < 21 & (thread4.getState() == State.NEW |
                    thread4.getState() == State.TERMINATED)) {
                thread4.start();
                threads.add(thread4);

            }
            if (QueueBuyers.getSizeDeque() >= 21 & (thread5.getState() == State.NEW |
                    thread5.getState() == State.TERMINATED)) {
                thread5.start();
                threads.add(thread5);
            }
        }


    }
}
