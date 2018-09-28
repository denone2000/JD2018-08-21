package by.it.korolchuk.jd02_02;

class Cashier implements Runnable {

    private int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " запущен");
        while (!Dispatcher.completePlan()) {
            Buyer buyer = QueueBuyers.pollBuyer();
            if (buyer != null) {
                int timeout = Util.random(2000, 5000);
                System.out.println(this + " начал обслуживать " + buyer);
                Util.sleep(timeout);
                System.out.println(this + " закончил обслуживать " + buyer);
                //wake buyer
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                Util.sleep(100);
            }
        }
        System.out.println(this + " остановлен");
    }

    @Override
    public String toString() {

        return "Cashier №" + number;
    }
}
