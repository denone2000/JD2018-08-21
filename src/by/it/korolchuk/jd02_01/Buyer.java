package by.it.korolchuk.jd02_01;

import static by.it.korolchuk.jd02_01.Good.*;
import static by.it.korolchuk.jd02_01.Util.*;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket = null;

    @Override
    public String toString() {
        return this.getName();
    }

    Buyer(int number) {
        super("Покупатель № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        putGoodsToBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void takeBasket() {

        Util.sleep(Util.random(100, 200));
        this.basket = new Basket();
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBasket() {

        Util.sleep(Util.random(100, 200));
        for (int i = 0; i < Util.random(goodsKeySet().size()); i++) {
            int counter = 0;
            int randomKey = Util.random(0, goodsKeySet().size());
            for (String good : goodsKeySet()) {
                if (randomKey == counter++) {
                    basket.put(good);
                    System.out.println(this + " взял " + good);
                }
            }
        }

String good;
        switch (basket.getKeys().size()) {
            case 0: good = "товаров";
            break;

            case 1: good = "товар";
            break;

            default: good = "товара";
            break;
        }
        System.out.println(this + " положил " + basket.getKeys().size() + " " + good);
    }


    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
        Dispatcher.addBuyer();
    }

    @Override
    public void chooseGoods() {

        System.out.println(this + " начал выбирать товары");
        int timeout = random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + " закончил выбирать товары");
    }

    @Override
    public void goOut() {
        Dispatcher.removeBuyer();
        System.out.println(this + " вышел из магазина");
    }


}
