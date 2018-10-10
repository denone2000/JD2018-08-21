package by.it.akhmelev.jd02_03;

class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this+" открыл кассу");
        while (!Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyers.pollBuyer();
            if (buyer != null) {
                System.out.println(this + " начал обслуживание: " + buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this + " завершил обслуживание: " + buyer);
                //wake buyer
                synchronized (buyer){
                    buyer.notify();
                }
            } else {
                Util.sleep(100);
            }
        }
        System.out.println(this+" закрыл кассу");
    }


    @Override
    public String toString() {
        return "\tКассир №" + number;
    }

}
