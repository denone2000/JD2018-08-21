package by.it.yaroshchuk.jd02_02;

import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    public Basket backet = new Basket();

     Buyer(int number) {
        super("Buyer № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
         Dispathcer.addBuyer();
        System.out.println(this + " ENTER THE MARKET");
    }

    @Override
    public void takeBacket() {
        System.out.println(this + " takes basket");
        int timeout = Util.random(100, 200);
        Util.sleep(timeout);
    }

    @Override
    public void chooseGoods() {
        System.out.println("----" + this + " is choosing");
        int timeout = Util.random(200, 500);

        Util.sleep(timeout);

        int amount = Util.random(1, 4);
        for (int i = 0; i < amount; i++) {
            int index = Util.random(0, Good.goods.size() - 1);
            Map.Entry<String, Double> good= Good.getGood(index);
            if(good != null) {
                System.out.println("------" + this + " choose " + good.getKey() + " price: " + good.getValue());
                putGoodsToBacket(good.getKey(), good.getValue());
            }
        }
    }

    @Override
    public void putGoodsToBacket(String key, Double value) {
        int timeout = Util.random(100, 200);
        Util.sleep(timeout);

        backet.addGoodInBasket(key, value);
        System.out.println("----" + this + " put good in basket");
    }

    @Override
    public void goToQueue() {
        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                System.out.println(this + " WAIT");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {

        System.out.println(this + " OUT");
        Dispathcer.removeBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
