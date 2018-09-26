package by.it.korolchuk.jd02_01;

import java.security.Key;
import java.util.*;

import static by.it.korolchuk.jd02_01.Goods.*;
import static by.it.korolchuk.jd02_01.Util.*;

public class Buyer extends  Thread implements IBuyer, IUseBasket {

    @Override
    public String toString() {
        return this.getName();
    }

    Buyer (int number) {
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

     public void takeBasket() {
        System.out.println(this + " взял корзину");
    }

    public void putGoodsToBasket(){

       // System.out.println(this + " положил в корзину");
        addGoods();



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
