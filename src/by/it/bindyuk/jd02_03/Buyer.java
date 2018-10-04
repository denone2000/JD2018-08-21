package by.it.bindyuk.jd02_03;

import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private Bucket bucket;
    //private static AtomicInteger buffBucket = new AtomicInteger(0);



    private Semaphore semaphore = new Semaphore(20);

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
        System.out.println(this + " entered to the market");
    }

    @Override
    public void takeBacket() {
        this.bucket = Market.bucketCollect.takeBucket();
        System.out.println("BUCKETS LEFT: " + Market.bucketCollect.sizeOfBuckets());
        //this.bucket = new Bucket();
        Utils.sleep(Utils.random(100, 200));
        System.out.println(this + " put the Backet");
    }

    @Override
    public void chooseGoods() {
        try {
            semaphore.acquire();
            System.out.println(this + " started to choose goods");
            for (int i = 0; i < Utils.random(1, 4); i++) {
                Map.Entry<String, Double> chooseGood = Goods.getRandomGoodWithPrice();
                bucket.putGoodWithPrice(chooseGood);
                System.out.println(this + " choose the " + (chooseGood != null ? chooseGood.getKey() : null) +
                        " with price: " + (chooseGood != null ? chooseGood.getValue() : null));
                Utils.sleep(Utils.random(100, 200));
            }
            Utils.sleep(Utils.random(500, 2000));
            System.out.println(this + " ended to choose goods");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

    @Override
    public void putGoodsToBacket() {
        Utils.sleep(Utils.random(100, 200));
        System.out.println(this + " put goods to backet");
    }

    @Override
    public void goToDeque() {
        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                System.out.println(this + " is waiting");
                System.out.println("IN DEQUE NOW: " + QueueBuyers.getSizeDeque() + " PEOPLES\n");
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
        //bucket.clearBucket();//remove
        Market.bucketCollect.bucketReturn(bucket);
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

