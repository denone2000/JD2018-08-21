package by.it.korolchuk.jd02_03;


import java.util.Map;
import java.util.concurrent.Semaphore;

import static by.it.korolchuk.jd02_03.Good.getGoodsMap;
import static by.it.korolchuk.jd02_03.Util.random;


public class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket = null;
    private static Semaphore marketSemaphore = new Semaphore(20);
   // private static Semaphore basketSemaphore = new Semaphore(50);

    @Override
    public String toString() {
        return this.getName();
    }

    Buyer(int number) {

        super("Buyer № " + number);
        Dispatcher.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGood();
        putGood();
        toQueue();
        goOut();
    }

    @Override
    public void takeBasket() {
        Util.sleep(random(100, 200));
        this.basket = new Basket();
        System.out.println(this + " took a basket");
    }

    @Override
    public void putGood() {

        Util.sleep(random(100, 200));
        for (int i = 1; i <= getGoodsMap().size(); i++) {
            int counter = 0;
            int randomKey = random(getGoodsMap().size());

            for (Map.Entry<String, Double> entry : Good.getGoodsMap().entrySet()) {
                if (randomKey == counter++) {
                    basket.putGood(entry);
                    //System.out.println(this + " put " + entry.getKey() +  " " + entry.getValue());
                }
            }
        }
        System.out.println(this + " finished choosing goods");
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to the market");
    }

    @Override
    public void chooseGood() {

        try {
            marketSemaphore.acquire();
            System.out.println(this + " began to choose goods");
            int timeout = random(500, 2000);
            Util.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            marketSemaphore.release();
        }
    }

    @Override
    public void toQueue() {

        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                System.out.println(this + " is waiting");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void takeOutGoods() {
        Double sum = 0.0;
        for (Map.Entry<String, Double> entry : basket.putGoodOut().entrySet()) {
            sum += entry.getValue();
            System.out.printf("%s.....%2.2f  \n", entry.getKey(), entry.getValue());
        }
        System.out.println("TOTAL....." + sum);
        Basket.clear(basket.putGoodOut());
        System.out.println("basket is empty");
    }

    @Override
    public void goOut() {
        Dispatcher.buyerLeftMarket();
        System.out.println(this + " exit from the market");
    }
}
