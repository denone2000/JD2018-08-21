package by.it.nesterovich.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioner;

    Buyer(int number) {
        super("Buyer № " + number);
        this.pensioner = number % 4 == 0;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        Dispatcher.addBuyer();
        System.out.println(this + " entered to market" + "         pensioner:" + pensioner);
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " started take basket");
        int timeout = Util.random(100, 200);
        if (pensioner) {
            timeout = (int) (1.5 * Util.random(100, 200));
        }

        Util.sleep(timeout);
        System.out.println(this + " finished take basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Util.random(10000, 30000);
        if (pensioner) {
            timeout = (int) (1.5 * Util.random(10000, 30000));
        }
        Util.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " started put good to basket");
        HashMap<String, Integer> basket = new HashMap<>();
        for (int i = 0; i < Util.random(1, 4); i++) {
            int price = Util.random(1, 100);
            String good = "good" + String.valueOf(price);
            basket.put(good, price);
            System.out.println(this + " put to basket good " + good + " with price " + price);
            int timeout = Util.random(100, 200);
            if (pensioner) {
                timeout = (int) (1.5 * Util.random(100, 200));
            }
            //для проверки скорости пенсионера
//            if (timeout > 200) {
//                System.out.println("       pensioner:" + pensioner + " " + this + " timeout:" + timeout);
//            }
            Util.sleep(timeout);
        }
        System.out.println(this + " finished put good to basket");
        //для вывода товаров находящихся в корзине
//        for (Map.Entry<String, Integer> element : basket.entrySet()) {
//            System.out.println("In basket " + this + " lie good " + element.getKey() + " with price  " + element.getValue());
//        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + " out from market");
        Dispatcher.removeBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
