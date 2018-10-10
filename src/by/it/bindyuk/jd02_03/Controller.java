package by.it.bindyuk.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller extends Thread {

    static ExecutorService executors = Executors.newFixedThreadPool(5);

    static AtomicInteger counterCashier = new AtomicInteger(0);

    static List<Thread> threads = new ArrayList<>();
    static int counterBuyer = 0;
    private static int buff = 1;

    @Override
    public void run() {
        while (!Dispatcher.planComplete()) {
            if ((QueueBuyers.getSizeDeque() > 0) & counterCashier.get() == 0) {
                createCashier();
                counterCashier.incrementAndGet();
            }
            if (counterCashier.get() > 0) {
                if ((QueueBuyers.getSizeDeque() / counterCashier.get()) >= 5) {
                    createCashier();
                    counterCashier.incrementAndGet();
                }
            }
        }
    }

    private void createCashier() {
        Cashier cashier = new Cashier(buff++);
        executors.execute(cashier);
    }
}
