package by.it.yaroshchuk.jd02_02;

class Dispathcer {

    static final int KSPEED = 100;



    private static int buyersInMarket = 0;
    private static int factCount = 0;
    private static int PLAN_COUNT = 0;
    private static int cashierWork = 0;


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

    static boolean marketIsOpened() {
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
