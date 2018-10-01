package by.it.basumatarau.jd02_03;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private Basket basket = null;
    private final boolean isPensioneer = Util.random(3)==3;
    private final double BUYER_KSPEED = isPensioneer? 1.5:1.0;

    boolean isPensioneer() {
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
        this.basket = Basket.getBasket();
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
        takeBasket();
        chooseGoods();
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
        Basket.returnBasket();
        //System.out.println(getName()+" has gone out");
    }

    @Override
    public String toString() {
        return getName();
    }
}
