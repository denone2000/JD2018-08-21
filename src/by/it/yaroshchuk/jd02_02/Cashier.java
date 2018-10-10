package by.it.yaroshchuk.jd02_02;

class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cashier № " + number;
    }

    @Override
    public void run() {
        Dispathcer.addCashier();
        System.out.println("-----------------------" + this + " started-------BUYERS IN QUEUE " + QueueBuyers.getCount());
        while (Dispathcer.checkWork() || this.number != Dispathcer.requiedWorkCash()) {
            Buyer buyer = QueueBuyers.pollBuyer();
            if(buyer != null) {
                int timeout = Util.random(200, 500);
                System.out.println("-----------------------" + this + " STARTED SERVICE " + buyer + "-----------------------");
                Util.sleep(timeout);
                System.out.println(buyer + " take " + buyer.backet.getGoodsInBacket());
                System.out.println("Total price " + buyer + ": " + buyer.backet.totalPrice());
                System.out.println(this + " STOP SERVICE " + buyer);
                //wake buyer
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                Util.sleep(100);
            }
        }
        System.out.println("-----------------------" + this + " stopped-------BUYERS IN QUEUE " + QueueBuyers.getCount());
        Dispathcer.removeCashier();
    }


}
