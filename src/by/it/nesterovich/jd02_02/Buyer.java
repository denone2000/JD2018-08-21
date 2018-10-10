package by.it.nesterovich.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private static List<Buyer> buyers = new ArrayList<>();
    private HashMap<String, Integer> basket = new HashMap<>();

    private boolean pensioner;

    Buyer(int number) {
        super("Buyer № " + number);
        Dispatcher.addBuyer();
        this.pensioner = number % 4 == 0;
    }

    HashMap<String, Integer> getBasket() {
        return basket;
    }

    public static List<Buyer> getBuyers() {
        return buyers;
    }

    static void addBuyersToList(Buyer buyers) {
        Buyer.buyers.add(buyers);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to market" + "         pensioner:" + pensioner);
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " started take basket ");
        int timeout = Util.random(100, 200);
        if (pensioner) {
            timeout = (int) (1.5 * Util.random(100, 200));
        }
        Util.sleep(timeout);
        System.out.println(this + " finished take basket ");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Util.random(500, 2000);
        if (pensioner) {
            timeout = (int) (1.5 * Util.random(500, 2000));
        }
        Util.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void goToQueue() {
        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                System.out.println(this+" is wait.");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " started put goods to basket");
        for (int i = 0; i < Util.random(1, 4); i++) {
            Goods goods = new Goods();
            //Basket basket = new Basket(goods.getGoods(), goods.getPrice());
            basket.put(goods.getGoods(), goods.getPrice());
            //System.out.println(this + " put to basket goods: " + goods.getGoods() + " with price " + goods.getPrice());
            int timeout = Util.random(100, 200);
            if (pensioner) {
                timeout = (int) (1.5 * Util.random(100, 200));
            }
            Util.sleep(timeout);
        }
        System.out.println(this + " finished put goods to basket");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " out from market");
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
