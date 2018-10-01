package by.it.nesterovich.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private static List<Buyer> buyers = new ArrayList<>();
    private static Semaphore semaphoreChooseGoods = new Semaphore(20);
    private Basket basket = new Basket(this);
    private boolean pensioner;
    private double speedBuyer;

    Buyer(int number) {
        super("Покупатель № " + number);
        Dispatcher.addBuyer();
        this.pensioner = number % 4 == 0;
        speedBuyer = pensioner ? 1.5 : 1.0;
    }

    boolean isPensioner(){
        return pensioner;
    }

    public static List<Buyer> getBuyers() {
        return buyers;
    }

    static void addBuyersToList(Buyer buyers) {
        Buyer.buyers.add(buyers);
    }

    HashMap<String, Integer> getBasket() {
        return basket.getBasket();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        try {
            semaphoreChooseGoods.acquire();
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreChooseGoods.release();
        }
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
        int timeout = (int) (speedBuyer * Util.random(100, 200));
        Util.sleep(timeout);
        basket.takeBasket();
        //System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {

        System.out.println(this + " начал выбор товаров");
        int timeout = (int) (speedBuyer * Util.random(500, 2000));
        Util.sleep(timeout);
        System.out.println(this + " завершил выбор товаров");

    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " начал ложить товары в корзину");
        for (int i = 0; i < Util.random(1, 4); i++) {
            Goods goods = new Goods();
            basket.addGoodsInBasket(goods.getGoods(), goods.getPrice());
            //System.out.println(this + ": положил в свою корзину товар " + goods.getGoods() + ", цена " + goods.getPrice());
            int timeout = (int) (speedBuyer * Util.random(100, 200));
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
