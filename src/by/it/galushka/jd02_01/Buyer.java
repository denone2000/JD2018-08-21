package by.it.galushka.jd02_01;

import java.util.*;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    Buyer(int number) {
        super("Buyer #" + number);
    }

    static boolean pensioneer;
    private final double KSPEED = pensioneer ? 1.5 : 1.0;

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
        if (pensioneer) {
            System.out.println(this + "(pensioneer) enter to market.");
        } else {
            System.out.println(this + " enter to market.");
        }
    }

    @Override
    public void chooseGoods() {
        int quantityGoods = Util.getRandom(1, 4);
        for (int goods = 0; goods < quantityGoods; goods++) {
            System.out.println(this + " start choosing goods.");
            Util.sleep((int) (Util.getRandom(500, 2000) * KSPEED));
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
        Util.sleep((int) (Util.getRandom(100, 200) * KSPEED));
        System.out.println(this + " took backet.");
    }

    @Override
    public void putGoodsToBacket() {

    }

    private void putGoodsToBacket(String good) {
        Util.sleep((int) (Util.getRandom(100, 200) * KSPEED));
        System.out.println(this + " put " + good + " to backet.");
    }
    //=========================================================================

    @Override
    public String toString() {
        return this.getName();
    }

}
