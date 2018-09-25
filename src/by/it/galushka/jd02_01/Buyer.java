package by.it.galushka.jd02_01;

import java.util.*;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    Buyer(int number) {
        super("Buyer #" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
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
        System.out.println(this + " start choose goods.");
        int timeForChoose = Util.getRandom(500, 2000);
        Util.sleep(timeForChoose);
        System.out.println(this + " end choose goods.");
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
        Map<String, Double> choosingGoods = new HashMap<>();
        for (int quantityGoods = 0; quantityGoods < Util.getRandom(4); quantityGoods++) {
            choosingGoods.putAll(Goods.getRandomGoods());
            Util.sleep(Util.getRandom(100, 200));
            List<String> goods = new ArrayList<>(choosingGoods.keySet());
            String lastAddedGood = goods.get(goods.size() - 1);
            System.out.println(this + " put to backet " + lastAddedGood + ".");
        }
    }
    //=========================================================================

    @Override
    public String toString() {
        return this.getName();
    }

}
