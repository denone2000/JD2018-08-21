package by.it.nesterovich.jd02_02;

class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " started");
        while (!Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyers.pollBuyer();
            if (buyer != null) {
                System.out.println(this + " started service " + buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this + " stop service " + buyer);
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
