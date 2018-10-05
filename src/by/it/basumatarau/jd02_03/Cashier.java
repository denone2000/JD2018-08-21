package by.it.basumatarau.jd02_03;

import java.util.Map;

public class Cashier implements Runnable {
    Cashier(int cashierNum){
        name = "Cashier#" + cashierNum;
        Dispatcher.addCashierOnShift();
        Dispatcher.openCashier();
        //see description on further usage in Dispatcher
        Dispatcher.addCashierMonitor(CASHIER_MONITOR, this);
    }

    private String name;
    private final Object CASHIER_MONITOR = new Object();
    private static double totalRevenue=0.0;
    private double currentBuyerBill =0.0;
    private boolean isWorking=true;
    private Buyer currBuyer = null;

    static double getTotalRevenue() {
        return totalRevenue;
    }
    double getCurrentBuyerBill() {
        return currentBuyerBill;
    }

    boolean isWorking() {
        return isWorking;
    }
    Buyer getCurrBuyer(){
        return currBuyer;
    }

    Object getCASHIER_MONITOR(){
        return CASHIER_MONITOR;
    }
    @Override
    public void run() {
        /*
         * Cashier goes to brake when right after the shift has started and there's nobody queuing
         * Controller thread (main) will notify one of the waiting Cashier threads when necessary
         * (a bit too slow...)
        * */
        if(Buyer.queuingBuyers()==0) {
            goToBreak();
        }

        while(Dispatcher.isNotOnTarget()){
            Buyer buyer = Buyer.pollBuyer();
            if(buyer!=null) {

                currBuyer=buyer;
                currentBuyerBill = buyer.putGoodsOutOfBasket().stream().map((good) -> {
                    Double result = 0.0;
                    for (Map.Entry<String, Double> entry : Goods.getGoods().entrySet()) {
                        if (entry.getKey().equals(good)) {
                            result = entry.getValue();
                        }
                    }
                    return result;
                }).reduce(0.0, (price1, price2) -> price1 + price2);
                totalRevenue+= currentBuyerBill;

                Util.sleep(Util.random(2000, 5000));
                //System.out.println(this + " has finished servicing " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }

                /* close the cashier if not enough customers in the queue
                 */
                if(Dispatcher.getOpenCashiers()>Math.ceil((double)Buyer.queuingBuyers()/5)){
                    goToBreak();
                }

            }else if(Dispatcher.getBuyersInMarket()>0){
                goToBreak();
            }
        }
        //the thread instance running the Cashier is going to terminate - cashier has done its shift
        Dispatcher.removeCashierOnShift();
        isWorking=false;
    }

    private void goToBreak() {
        synchronized (CASHIER_MONITOR) {
            try {
                Dispatcher.closeCashier();
                isWorking = false;
                CASHIER_MONITOR.wait();
                isWorking = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString(){
        return name;
    }
}
