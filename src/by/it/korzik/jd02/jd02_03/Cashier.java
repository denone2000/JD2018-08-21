package by.it.korzik.jd02.jd02_03;

import by.it.korzik.jd02.jd02_03.Buyer;
import by.it.korzik.jd02.jd02_03.BuyersQueue;
import by.it.korzik.jd02.jd02_03.Util;

public class Cashier implements Runnable{

    private static volatile int number;

    public Cashier(int num){
        number = num;
    }

    @Override
    public void run() {
        System.out.println(this+" начал работу");
        while(!Util.planComplete()){
            Buyer buyer = BuyersQueue.pollBuyer();
            if (buyer != null) {
                int timeout = Util.random(2000, 5000);
                System.out.println(this + " начал обслуживание " + buyer.getName());
                Util.sleep(timeout);
                System.out.println(this + " закончил обслуживание " + buyer.getName());
                synchronized
                        (buyer){
                    buyer.notify();
                }
                synchronized (Util.class){
                    Util.plan.incrementAndGet();}
            } else {
                Util.sleep(100);
            }
        }
        System.out.println(this+" закончил работу");
    }


    @Override
    public String toString() {
        return "Кассир№"+number;
    }
}
