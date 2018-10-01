package by.it.korolchuk.jd02_02;


import static by.it.korolchuk.jd02_02.Good.goodsKeySet;
import static by.it.korolchuk.jd02_02.Util.random;


public class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket = null;

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
        putGoodsToBasket();
        chooseGoods();
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
    public void putGoodsToBasket() {

        Util.sleep(random(100, 200));
        for (int i = 1; i <= goodsKeySet().size(); i++) {
                int counter = 0;
                int randomKey = random(goodsKeySet().size());
                for (String good : goodsKeySet()) {
                   if (randomKey == counter++) {
                        basket.put(good);
                        System.out.println(this + " took " + good);
                    }
                }
            }

String good;
        switch (basket.getKeys().size()) {
            case 0: good = "goods";
            break;

            case 1: good = "good";
            break;

            default: good = "goods";
            break;
        }
        System.out.println(this + " put " + basket.getKeys().size() + " " + good + " to the basket");
    }


    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to the market");

    }

    @Override
    public void chooseGoods() {

        System.out.println(this + " start choosing goods");
        int timeout = random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + " finished choosing goods");
    }

    @Override
    public void toQueue() {

        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                System.out.println(this + " is waiting");
                this.wait();
            }
            catch ( InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        Dispatcher.buyerLeftMarket();
        System.out.println(this + " exit from the market");
    }


}
