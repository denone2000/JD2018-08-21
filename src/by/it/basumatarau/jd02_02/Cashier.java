package by.it.basumatarau.jd02_02;

import java.util.Map;

public class Cashier implements Runnable {
    private String name;
    Cashier(int cashierNum){
        name = "Cashier#" + cashierNum;
        Dispatcher.addCashierOnShift();
        Dispatcher.openCashier();
        Dispatcher.addCashierMonitor(CASHIER_MONITOR, this);
    }
    private final Object CASHIER_MONITOR = new Object();

    static double getTotalRevenue() {
        return totalRevenue;
    }

    private static double totalRevenue=0.0;
    private boolean isWorking=true;
    private String currentBuyerName =null;
    private Buyer currBuyer = null;

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
        //System.out.println(this +" has started service");

        while(Dispatcher.isNotOnTarget()){
            Buyer buyer = Buyer.pollBuyer();
            if(buyer!=null) {

                currBuyer=buyer;
                //System.out.println(this + " is servicing " + buyer);
                double charge = buyer.putGoodsOutOfBasket().stream().map((good) -> {
                    Double result = 0.0;
                    for (Map.Entry<String, Double> entry : Goods.getGoods().entrySet()) {
                        if (entry.getKey().equals(good)) {
                            result = entry.getValue();
                        }
                    }
                    return result;
                }).reduce(0.0, (price1, price2) -> price1 + price2);
                //System.out.printf("%s has been charged %s$\n", buyer ,charge);
                totalRevenue+=charge;

                Util.sleep(Util.random(2000, 5000));
                //System.out.println(this + " has finished servicing " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }

                //currBuyer=null;
                if(Dispatcher.getOpenCashiers()>Dispatcher.getBuyersInMarket()/5&&
                Dispatcher.isOpen()){
                    synchronized (CASHIER_MONITOR){
                        try {
                            //System.out.println(this + " is waiting for more customers to come to the market");
                            Dispatcher.closeCashier();
                            isWorking=false;
                            CASHIER_MONITOR.wait();
                            isWorking=true;
                            //System.out.println(this + " got back to work");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }else if(Dispatcher.getBuyersInMarket()>0){
                synchronized (CASHIER_MONITOR){
                    try {
                        //System.out.println(this + " is waiting for the customers");
                        Dispatcher.closeCashier();
                        isWorking=false;
                        CASHIER_MONITOR.wait();
                        isWorking=true;
                        //System.out.println(this + " got back to work");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //System.out.println(this + " has done its shift");
        Dispatcher.removeCashierOnShift();
        isWorking=false;
    }
    @Override
    public String toString(){
        return name;
    }
}
