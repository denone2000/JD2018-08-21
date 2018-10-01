package by.it.basumatarau.jd02_03;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static final int KSPEED = 100;
    private static final int TARGET = 100;
    private static AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static AtomicInteger buyersLeftMarket = new AtomicInteger(0);

    private static AtomicInteger cashiersOpen = new AtomicInteger(0);
    private static AtomicInteger cashiersOnShift = new AtomicInteger(0);

    private final static HashMap<Object, Cashier> cashierMonitors = new HashMap<>();

    static void addCashierMonitor(Object monitor, Cashier cashier){
        cashierMonitors.put(monitor, cashier);
    }
    static HashMap<Object, Cashier> getCashierMonitors() {
        return cashierMonitors;
    }


    static void addCashierOnShift(){
        cashiersOnShift.getAndIncrement();
    }

    static void removeCashierOnShift(){
        cashiersOnShift.getAndDecrement();
    }
    static int getCashiersOnShift(){
        return cashiersOnShift.get();
    }

    static void openCashier(){
        cashiersOpen.getAndIncrement();
    }
    static void closeCashier(){
        cashiersOpen.getAndDecrement();
    }
    static int getOpenCashiers(){
        return cashiersOpen.get();
    }

    static boolean isNotOnTarget(){
        return TARGET > buyersLeftMarket.get();
    }

    static boolean isOpen(){
        return (buyersInMarket.get()+buyersLeftMarket.get())<TARGET;
    }

    static int getBuyersLeftMarket(){
        return buyersLeftMarket.get();
    }

    static void addBuyer() {
        buyersInMarket.getAndIncrement();
    }

    static void removeBuyer() {
        buyersInMarket.getAndDecrement();
        buyersLeftMarket.getAndIncrement();
    }

    static int getBuyersInMarket() {
        return buyersInMarket.get();
    }

}
