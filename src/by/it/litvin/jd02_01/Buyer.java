package by.it.litvin.jd02_01;


import java.util.*;

class Buyer extends Thread implements IBuyer, IUseBacket {
    private Backet backet;

    Buyer(int number) {
        super("Buyer № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();

    }

    @Override
    public void enterToMarket() {
        Dispathcer.addBuyer();
        System.out.println(this + " entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Util.randomInt(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " out from market");
        Dispathcer.removeBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        System.out.println(this + " takes backet");
        backet = new Backet();
        double timeChoosing = Util.randomDouble(0.1, 0.2);
        Util.sleep((int) (timeChoosing * 1000));
        System.out.println(this + " got backet");
    }

    @Override
    public void putGoodsToBacket() {
        List<Good> goods = new ArrayList<>();
        System.out.println(this + " put goods");
        double timeChoosing = Util.randomDouble(0.1, 0.2);
        Util.sleep((int) (timeChoosing * 1000));
        int count = Util.randomInt(1, 4);
        for (Map.Entry<Good, Integer> entry : ShoppingCard.map.entrySet()) {
            goods.add(entry.getKey());
            if (goods.size() == count) {
                backet.setGoods(goods);
                break;
            }

        }
        System.out.println(this + " choosed" + Arrays.toString(backet.getGoods().toArray()));


    }
}
