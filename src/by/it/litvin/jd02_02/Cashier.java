package by.it.litvin.jd02_02;

class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this+" started");
        while (!Dispathcer.planComplete()) {
            Buyer buyer = QueueBuyers.pollBuyer();
            if (buyer != null) {
                int timeout = Util.randomInt(2000, 5000);
                System.out.println(this + " started service " + buyer);
                Util.sleep(timeout);
                System.out.println(this + " stop service " + buyer);
                //wake buyer
                synchronized (buyer){
                    buyer.notify();
                }
            } else {
                Util.sleep(100);
            }
        }
        System.out.println(this+" stopped");
    }


    @Override
    public String toString() {
        return "Cashier №" + number;
    }

}
