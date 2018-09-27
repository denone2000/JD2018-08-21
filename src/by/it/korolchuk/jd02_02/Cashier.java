package by.it.korolchuk.jd02_02;

public class Cashier implements Runnable {

    static  int number;

    Cashier(int number) {
        this.number = number;
    }

   @Override
    public void run() {
        while (Dispatcher.completePlan()) {
        //Buyer buyer = new Buyer()
        }
    }
}
