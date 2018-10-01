package by.it.bindyuk.jd02_03;

import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private Bucket bucket;
    private boolean pensioneer;
    private Semaphore semaphore = new Semaphore(20);

    {
        int noLucky = 4;
        int pensioneerDetected = Utils.random(0, 4);
        if (pensioneerDetected == noLucky) pensioneer = true;
    }


    Buyer(int number) {
        super("Buyer № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToDeque();
        goOut();
    }

    @Override
    public void enterToMarket() {
        Dispatcher.addBuyer();
        if (pensioneer) {
            System.out.println(this + " (pensioneer) entered to the market");
        } else
            System.out.println(this + " entered to the market");
    }

    @Override
    public void takeBacket() {
        this.bucket = new Bucket();
        if (pensioneer) {
            Utils.sleep(Utils.random(150, 300));
        } else {
            Utils.sleep(Utils.random(100, 200));
        }
        System.out.println(this + " put the Backet");
    }

    @Override
    public void chooseGoods() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " started to choose goods");
        for (int i = 0; i < Utils.random(1, 4); i++) {
            Map.Entry<String, Double> chooseGood = Goods.getRandomGoodWithPrice();
            bucket.putGoodWithPrice(chooseGood);
            System.out.println(this + " choose the " + (chooseGood != null ? chooseGood.getKey() : null) +
                    " with price: " + (chooseGood != null ? chooseGood.getValue() : null));
            if (pensioneer) {
                Utils.sleep(Utils.random(150, 300));
            } else {
                Utils.sleep(Utils.random(100, 200));
            }
        }
        if (pensioneer) {
            Utils.sleep(Utils.random(750, 3000));
        } else {
            Utils.sleep(Utils.random(500, 2000));
        }
        System.out.println(this + " ended to choose goods");
    }

    @Override
    public void putGoodsToBacket() {
        if (pensioneer) {
            Utils.sleep(Utils.random(150, 300));
        } else {
            Utils.sleep(Utils.random(100, 200));
        }
        System.out.println(this + " put goods to backet");
    }

    @Override
    public void goToDeque() {
        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                System.out.println(this + " is waiting");
                System.out.println("IN DEQUE NOW: " + QueueBuyers.getSizeDeque() + " PEOPLES\n");
                semaphore.release();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void putGoodsToCashier() {
        System.out.println("In " + this + " Bucket: " + bucket.getChoosenGoodsWithPrice());
        double check = 0.0;
        for (Map.Entry<String, Double> entry : bucket.getChoosenGoodsWithPrice().entrySet()) {
            check += entry.getValue();
        }
        System.out.println(this + " own " + Math.rint(100.0 * check) / 100.0 + " rubles ");
    }

    @Override
    public void goOut() {
        System.out.println(this + " went out the Market");
        Dispatcher.subBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

