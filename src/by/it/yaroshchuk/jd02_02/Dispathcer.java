package by.it.yaroshchuk.jd02_02;

class Dispathcer {

    static final int KSPEED = 100;



    private static volatile int buyersInMarket = 0;
    private static volatile int factCount = 0;
    private static final int PLAN_COUNT = 100;
    private static volatile int cashierWork = 0;


    static synchronized void addBuyer() {
        buyersInMarket++;
    }

    static synchronized void removeBuyer() {
        buyersInMarket--;
        factCount++;
    }

    static int getBuyersInMarket() {
        return buyersInMarket;
    }

    static synchronized boolean marketIsOpened() {
        return (buyersInMarket + factCount) < PLAN_COUNT;
    }



    static synchronized void addCashier() {
        cashierWork++;
    }

    static synchronized void removeCashier() {
        cashierWork--;
    }

    static int getCashiersWork() {
        return cashierWork;
    }

    static int requiedWorkCash(){
        int buyersAmount = QueueBuyers.getCount();
        if(buyersAmount < 10 && Dispathcer.getBuyersInMarket() != 0)
            return 1;
        if(buyersAmount >= 10)
            return buyersAmount / 5;
        return 0;
    }

    static synchronized boolean checkWork(){
        if(requiedWorkCash() < Dispathcer.getCashiersWork())
            return false;
        return true;
    }
}
