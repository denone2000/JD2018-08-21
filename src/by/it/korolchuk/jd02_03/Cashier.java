package by.it.korolchuk.jd02_03;




class Cashier implements Runnable {

    private int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override

    public void run() {
        System.out.println(this + " started");
        while (!Dispatcher.completePlan()) {
            Buyer buyer = QueueBuyers.pollBuyer();
            if (buyer != null) {
                int timeout = Util.random(2000, 5000);
                System.out.println(this + " started servicing " + buyer);
                buyer.takeOutGoods();
                Util.sleep(timeout);
                System.out.println(this + " stopped servicing " + buyer);
                //wake buyer
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                Util.sleep(100);
            }
        }
        System.out.println(this + " stopped");
    }

    @Override
    public String toString() {

        return "Cashier №" + number;
    }


}
