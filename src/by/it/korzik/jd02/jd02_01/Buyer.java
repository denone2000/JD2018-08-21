package by.it.korzik.jd02.jd02_01;

import by.it.korzik.jd02.jd02_01.IBuyer;
import by.it.korzik.jd02.jd02_01.IUseBacket;
import by.it.korzik.jd02.jd02_01.Util;

import java.util.Map;
import java.util.Set;

import static by.it.korzik.jd02.jd02_01.Market.goodsMap;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    Buyer(int num) {
        super("Покупатель" + num);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + " вошел в магазин");
    }

    @Override
    public void takeBacket() {
        int random = by.it.korzik.jd02.jd02_01.Util.random(100, 200);
        by.it.korzik.jd02.jd02_01.Util.sleep(random);
        System.out.println(this.getName() + " взял корзину");
    }


    @Override
    public void chooseGoods() {
        int random1 = by.it.korzik.jd02.jd02_01.Util.random(1, 4);
        for (int i = 0; i < random1; i++) {
            int random = by.it.korzik.jd02.jd02_01.Util.random(500, 2000);
            by.it.korzik.jd02.jd02_01.Util.sleep(random);
            System.out.println(this.getName() + " выбирает товар");
            putGoodsToBacket();
        }
    }

    @Override
    public void putGoodsToBacket() {
        int random = by.it.korzik.jd02.jd02_01.Util.random(100, 200);
        by.it.korzik.jd02.jd02_01.Util.sleep(random);
        String goods = choose();
        System.out.println(this.getName() + " положил " + goods + " в корзину");
    }

    private String choose() {
        int count = 0;
        int size = (goodsMap.size() - 1);
        int choose = by.it.korzik.jd02.jd02_01.Util.random(size);
        Set<Map.Entry<String, Integer>> entries = goodsMap.entrySet();
        for (Map.Entry<String, Integer> next : entries) {
            if (count != choose) {
                count++;
            } else {
                return next.getKey();
            }
        }
        return null;
    }

    @Override
    public void goOut() {
        System.out.println(this.getName() + " вышел из магазина");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }
}
