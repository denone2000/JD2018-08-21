package by.it.basumatarau.jd02_02;

import java.util.HashMap;

class Dispatcher {
    static final int KSPEED = 10;
    private static final int TARGET = 100;
    private static volatile int buyersInMarket = 0;
    private static volatile int buyersLeftMarket = 0;

    private static volatile int cashiersOpen =0;
    private static volatile int cashiersOnShift =0;

    private final static HashMap<Object, Cashier> cashierMonitors = new HashMap<>();

    synchronized static void addCashierMonitor(Object monitor, Cashier cashier){
        cashierMonitors.put(monitor, cashier);
    }
    static HashMap<Object, Cashier> getCashierMonitors() {
        return cashierMonitors;
    }


    synchronized static void addCashierOnShift(){
        cashiersOnShift++;
    }

    synchronized static void removeCashierOnShift(){
        cashiersOnShift--;
    }
    synchronized static int getCashiersOnShift(){
        return cashiersOnShift;
    }

    synchronized static void openCashier(){
        cashiersOpen++;
    }
    synchronized static void closeCashier(){
        cashiersOpen--;
    }
    synchronized static int getOpenCashiers(){
        return cashiersOpen;
    }

    synchronized static boolean isNotOnTarget(){
        return TARGET > buyersLeftMarket;
    }

    synchronized static boolean isOpen(){
        return (buyersInMarket+buyersLeftMarket)<TARGET;
    }

    synchronized static int getBuyersLeftMarket(){
        return buyersLeftMarket;
    }

    synchronized static void addBuyer() {
        buyersInMarket++;
    }

    synchronized static void removeBuyer() {
        buyersInMarket--;
        buyersLeftMarket++;
    }

    synchronized static int getBuyersInMarket() {
        return buyersInMarket;
    }

}
