package by.it.nesterovich.jd02_03;

import java.util.HashMap;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket = new Basket(this);

    Buyer(int number) {
        super("Покупатель № " + number);
        Dispatcher.addBuyer();
    }

    HashMap<String, Integer> getBasket() {
        return basket.getBasket();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBasket() {
        //System.out.println(this + " started take basket ");
        int timeout = Util.random(100, 200);
        Util.sleep(timeout);
        basket.takeBasket();
        //System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " начал выбор товаров");
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + " завершил выбор товаров");
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " начал ложить товары в корзину");
        for (int i = 0; i < Util.random(1, 4); i++) {
            Goods goods = new Goods();
            basket.addGoodsInBasket(goods.getGoods(), goods.getPrice());
            System.out.println(this + ": положил в свою корзину товар " + goods.getGoods() + ", цена " + goods.getPrice());
            int timeout = Util.random(100, 200);
            Util.sleep(timeout);
        }
        System.out.println(this + " закончил ложить товары в корзину");
    }

    @Override
    public void goToQueue() {
        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                System.out.println(this + " ожидает в очереди. ");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        basket.returnBasket();
        System.out.println(this + " вышел из магазина");
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
