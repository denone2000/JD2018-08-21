package by.it.litvin.jd02_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBacket {
    private Backet backet;
    private Semaphore semaphore=new Semaphore(20);

    Buyer(int number) {
        super("Buyer № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
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
        try {
            semaphore.acquire();
        System.out.println(this + " started to choose goods");
        int timeout = Util.randomInt(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        }

    @Override
    public void goOut() {
        System.out.println(this + " out from market");
        Dispathcer.buyerLeaveMarket();
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
    public void goToQueue() {
        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                System.out.println(this+" is wait.");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
