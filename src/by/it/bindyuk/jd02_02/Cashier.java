package by.it.bindyuk.jd02_02;

class Cashier implements Runnable {
    private String name;

    @Override
    public String toString() {
        return name;
    }

    Cashier(int number) {
        name = "Cashier № " + number;
    }

    @Override
    @SuppressWarnings("all")
    public void run() {
        System.out.println(this + " started");
        while (QueueBuyers.getSizeDeque()!=0) {
            Buyer buyer = QueueBuyers.pollBuyer();
            if (buyer != null) {
                System.out.println(this + " started to service " + buyer);
                buyer.putGoodsToCashier();
                Utils.sleep(Utils.random(2000, 5000));
                System.out.println(this + " ended to service " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else Utils.sleep(100);
        }
        System.out.println(this + " stopped");
    }
}
