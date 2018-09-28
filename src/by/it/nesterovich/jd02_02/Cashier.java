package by.it.nesterovich.jd02_02;

import java.util.Map;

class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        String indent = "     ";
        System.out.println("                                 " + this + " started.");
        //while (!Dispatcher.planComplete()) {
        while (QueueBuyers.getCount() > 0 || !Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyers.pollBuyer();
            if (buyer != null) {
                System.out.println(indent + this + " started service " + buyer);
                int totalAmountOfCheck = 0;
                for (Map.Entry<String, Integer> good : buyer.getBasket().entrySet()) {
                    System.out.println(indent + buyer + ": good " + good.getKey() + ", price  " + good.getValue());
                    totalAmountOfCheck += good.getValue();
                }
                System.out.println(indent + "Total amount of check " + buyer + ": " + totalAmountOfCheck);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(indent + this + " stop service " + buyer);
                //wake buyer
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                Util.sleep(100);
            }
        }
        System.out.println("                                 " + this + " stopped.");
    }

    @Override
    public String toString() {
        return "Cashier №" + number;
    }

}
