package by.it.yaroshchuk.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispathcer {

    static final int KSPEED = 100;

    private static AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static AtomicInteger factCount = new AtomicInteger(0);
    private static AtomicInteger PLAN_COUNT = new AtomicInteger(100);
    private static AtomicInteger cashierWork = new AtomicInteger(0);


    static void addBuyer() {
        buyersInMarket.incrementAndGet();
    }

    static void removeBuyer() {
        buyersInMarket.decrementAndGet();
        factCount.incrementAndGet();
    }

    static int getBuyersInMarket() {
        return buyersInMarket.get();
    }

    static boolean marketIsOpened() {
        return (buyersInMarket.get() + factCount.get()) < PLAN_COUNT.get();
    }

    static void addCashier() {
        cashierWork.incrementAndGet();
    }

    static void removeCashier() {
        cashierWork.decrementAndGet();
    }

    static int getCashiersWork() {
        return cashierWork.get();
    }

    static int requiedWorkCash(){
        int buyersAmount = QueueBuyers.getCount();
        if(buyersAmount < 10 && Dispathcer.getBuyersInMarket() != 0)
            return 1;
        if(buyersAmount >= 10)
            return buyersAmount / 5;
        return 0;
    }

    static boolean checkWork(){
        return requiedWorkCash() >= Dispathcer.getCashiersWork();
    }
}
