package by.it.nesterovich.jd02_03;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Cashier implements Runnable {

    private int number;
    private static AtomicInteger totalRevenueMarket = new AtomicInteger(0);

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("\t\t" + this + " открыл кассу");
        while (!Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyers.pollBuyer();
            if (buyer != null) {
                StringBuffer sbCash = new StringBuffer();
                sbCash.append("\t\t").append(this).append(" начал обслуживание: ").append(buyer).append("\n");
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);

                int totalAmountOfCheck = 0;
                for (Map.Entry<String, Integer> good : buyer.getBasket().entrySet()) {
                    StringBuffer[] stringBuffers = new StringBuffer[7];
                    for (int i = 0; i < 7; i++) {
                        if (i == number - 1) {
                            stringBuffers[i] = new StringBuffer(String.format("%15s", good.getKey() + "...." + good.getValue()) + "|");
                        } else {
                            stringBuffers[i] = new StringBuffer(String.format("%15s", "|"));
                        }
                        sbCash.append(stringBuffers[i]);
                    }
                    sbCash.append("\n");
                    totalAmountOfCheck += good.getValue();
                }
                totalRevenueMarket.getAndAdd(totalAmountOfCheck);

                StringBuffer[] stringBuffers = new StringBuffer[7];
                for (int i = 0; i < 7; i++) {
                    if (i == number - 1) {
                        stringBuffers[i] = new StringBuffer(String.format("%16s", "ИТОГО...." + totalAmountOfCheck + "|"));  //где пропадает один символ?
                    } else if (i == 5) {
                        stringBuffers[i] = new StringBuffer(String.format("%15s", "очередь: " + QueueBuyers.getCount() + "|"));
                    } else if (i == 6) {
                        stringBuffers[i] = new StringBuffer(String.format("%15s", "выручка: " + totalRevenueMarket + "|"));
                    } else {
                        stringBuffers[i] = new StringBuffer(String.format("%15s", "|"));
                    }
                    sbCash.append(stringBuffers[i]);
                }
                sbCash.append("\n");
                sbCash.append("\t\t").append(this).append(" завершил обслуживание: ").append(buyer);
                System.out.println(sbCash.toString());
                //wake buyer
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                Util.sleep(100);
            }
        }
        System.out.println("\t\t" + this + " закрыл кассу");
    }

    private void writeLineCashBuyer(Buyer buyer) {
        int totalAmountOfCheck = 0;
        for (Map.Entry<String, Integer> good : buyer.getBasket().entrySet()) {
            System.out.println("\t\t\t" + buyer + ": " + good.getKey() + "............." + good.getValue());
            totalAmountOfCheck += good.getValue();
        }
        System.out.println("\t\t\tИТОГО: " + buyer + "..............." + totalAmountOfCheck);
    }

    @Override
    public String toString() {
        return "Кассир №" + number;
    }

}
