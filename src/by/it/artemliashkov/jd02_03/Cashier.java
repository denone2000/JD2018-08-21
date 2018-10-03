package by.it.artemliashkov.jd02_03;

import java.util.Map;

class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        String indent = "  ";
        System.out.println("" + this + " начал.");
        while (QueueBuyers.getCount() > 0 || !Discpathcer.planComplete()) {
            Buyer buyer = QueueBuyers.pollBuyer();
            if (buyer != null) {
                System.out.println(indent + this + " начал обслуживать" + buyer);
                int totalAmountOfCheck = 0;
                for (Map.Entry<String, Integer> good : buyer.getBasket().entrySet()) {
                    System.out.println(indent + buyer + ": товар " + good.getKey() + ", стоимость  " + good.getValue());
                    totalAmountOfCheck += good.getValue();
                }
                System.out.println(indent + "Общая сумма " + buyer + ": " + totalAmountOfCheck);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(indent + this + " прекратил работать " + buyer);
                //wake buyer
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                Util.sleep(100);
            }
        }
        System.out.println(" " + this + " прекратил работу.");
    }

    @Override
    public String toString() {
        return "Кассир №" + number;
    }

}