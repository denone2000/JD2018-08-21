package by.it.basumatarau.jd02_03;

import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket = null;
    private final boolean isPensioneer = Util.random(3)==3;
    private final double BUYER_KSPEED = isPensioneer? 1.5:1.0;
    private final static Lock lockBuyersQueue = new ReentrantLock();

    /**
     * amount of buyers (threads) allowed to choose goods at the same time
     * is limited to 20 (all the rest threads are blocked by semaphoreMarketCapacity)
     * */
    private static Semaphore semaphoreMarketCapacity = new Semaphore(20);
    /**
     * amount of baskets is limited to 50, so the amount of threads Buyers (threads)
     * simultaneously handling an instance of a Basket is limited to 50
     * (all the rest threads are blocked by semaphoreBaskets)
     * */
    private static Semaphore semaphoreBaskets = new Semaphore(50);

    boolean isPensioner() {
        return isPensioneer;
    }

    private final static PriorityBlockingQueue<Buyer> BUYERS_QUEUE = new PriorityBlockingQueue<>(30,(b1, b2)->{
        if(b1.isPensioneer&&!b2.isPensioneer){
            return -1;
        }else if(!b1.isPensioneer&&b2.isPensioneer){
            return 1;
        }else{
            return b1.getName().compareTo(b2.getName());
        }
    });

    Buyer(int customerNumber){
        super("Customer#"+customerNumber);
        Dispatcher.addBuyer();
    }
    static int queuingBuyers(){
        return BUYERS_QUEUE.size();
    }
    static Buyer pollBuyer(){
        return BUYERS_QUEUE.poll();
    }

    @Override
    public void takeBasket() {
        Util.sleep(Util.random((int)(100* BUYER_KSPEED),(int) (200* BUYER_KSPEED)));
        this.basket = new Basket();
        //System.out.println(getName()+" took a basket");
    }

    @Override
    public void putGoodsToBasket() {
        for (int i = 0; i < Util.random(1,4); i++) {
            Util.sleep(Util.random((int)(100* BUYER_KSPEED),(int) (200* BUYER_KSPEED)));

            int dice = Util.random(0, Goods.getGoods().size()-1);
            int iterator = 0;
            for (Map.Entry<String, Double> entry: Goods.getGoods().entrySet()) {
                if (dice==iterator++){
                    basket.addGood(entry.getKey());
                    //System.out.println(getName()+" has put "+entry.getKey()+" in the basket");
                }
            }
        }
        //System.out.println(getName()+" proceeds to checkout with "+basket.getGoods()+" in the basket");
    }

    @Override
    public List<String> putGoodsOutOfBasket() {
        return basket.getGoods();
    }

    @Override
    public void run() {
        enterToMarket();
        try {
            semaphoreBaskets.acquire();
            takeBasket();
            try {
                semaphoreMarketCapacity.acquire();
                chooseGoods();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphoreMarketCapacity.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreBaskets.release();
        }
        putGoodsToBasket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        //System.out.println(getName()+" entered market");
    }

    @Override
    public void chooseGoods() {
        Util.sleep(Util.random((int)(200* BUYER_KSPEED), (int)(400* BUYER_KSPEED)));
        //System.out.println(getName()+" has chosen some goods");
    }

    @Override
    public void goToQueue() {
        if(BUYERS_QUEUE.size()>=29){
            try{
                lockBuyersQueue.lock();
                takePlaceInQueue();
            }finally{
                lockBuyersQueue.unlock();
            }
        }else{
            takePlaceInQueue();
        }
    }

    private void takePlaceInQueue() {
        BUYERS_QUEUE.put(this);

        synchronized (this) {
            try {
                //System.out.println(this + " has joined the queue");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        Dispatcher.removeBuyer();
        //System.out.println(getName()+" has gone out");
    }

    @Override
    public String toString() {
        return getName();
    }
}
