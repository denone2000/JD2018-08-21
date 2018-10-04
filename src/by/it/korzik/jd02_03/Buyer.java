package by.it.korzik.jd02_03;

import java.util.Map;
import java.util.Set;

import static by.it.korzik.jd02_03.Market.goodsMap;


public class Buyer extends Thread implements IBuyer, IUseBacket {

    Buyer(int num) {
        super("Покупатель" + num);
        Util.addBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + " вошел в магазин");
    }

    @Override
    public void takeBacket() {
        int random = Util.random(100, 200);
        Util.sleep(random);
        System.out.println(this.getName() + " взял корзину");
    }


    @Override
    public void chooseGoods() {
        int random1 = Util.random(1, 4);
        for (int i = 0; i < random1; i++) {
            int random = Util.random(500, 2000);
            Util.sleep(random);
            System.out.println(this.getName() + " выбирает товар");
            putGoodsToBacket();
        }
    }

    @Override
    public void goToQueue() {
        BuyersQueue.addBuyer(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void putGoodsToBacket() {
        int random = Util.random(100, 200);
        Util.sleep(random);
        String goods = choose();
        System.out.println(this.getName() + " положил " + goods + " в корзину");
    }

    private String choose() {
        int count = 0;
        int size = (goodsMap.size() - 1);
        int choose = Util.random(size);
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
        goToQueue();
        goOut();
    }
}
