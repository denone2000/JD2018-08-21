package by.it.galushka.jd02_01;

import java.util.*;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    Buyer(int number) {
        super("Buyer #" + number);
    }

    static boolean pensioneer;

    static double pensioneerCheck() {
        double kSpeed;
        if (pensioneer) {
            kSpeed = 1.5;
        } else
            kSpeed = 1.0;
        return kSpeed;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }

    //========================================================================
    // IBuyer methods
    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market.");
    }

    @Override
    public void chooseGoods() {
        int quantityGoods = Util.getRandom(1, 4);
        for (int goods = 0; goods < quantityGoods; goods++) {
            System.out.println(this + " start choosing goods.");
            Util.sleep(Util.getRandom(500, 2000));
            Map<String, Double> choosedGood = Goods.getRandomGood();
            String good = Goods.getGoodName(choosedGood);
            double cost = Goods.getGoodCost(choosedGood);
            System.out.println(this + " choosed " + good + ", cost - " + cost + " rubles.");
            putGoodsToBacket(good);
        }
        System.out.println(this + " end choosing goods today.");
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out.");
    }
    //=========================================================================

    //=========================================================================
    // IUseBacket methods
    @Override
    public void takeBacket() {
        Util.sleep(Util.getRandom(100, 200));
        System.out.println(this + " took backet.");
    }

    @Override
    public void putGoodsToBacket() {
    }
    //=========================================================================

    private void putGoodsToBacket(String good) {
        Util.sleep(Util.getRandom(100, 200));
        System.out.println(this + " put " + good + " to backet.");
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
