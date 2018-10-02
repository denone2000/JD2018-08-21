package by.it.yaroshchuk.jd02_01;

import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket{

     Buyer(int number) {
        super("Buyer № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
         Dispathcer.addBuyer();
        System.out.println("--------------------" + this + " ENTER THE MARKET");
    }



    @Override
    public void goOut() {
        System.out.println("--------------------" + this + " OUT");
        Dispathcer.removeBuyer();
    }

    @Override
    public void takeBacket() {
        System.out.println("----" + this + " takes basket");
        int timeout = Util.random(100, 200);
        Util.sleep(timeout);
    }

    @Override
    public void chooseGoods() {
        System.out.println("----" + this + " is choosing");
        int timeout = Util.random(500, 2000);

        Util.sleep(timeout);

        for (int i = 1; i < 5; i++) {
            Map.Entry<String, Double> good= Good.getGood(i);
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
        Basket.addGoodInBasket(key, value);
        System.out.println("----" + this + " put good to basket");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
