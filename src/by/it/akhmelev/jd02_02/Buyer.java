package by.it.akhmelev.jd02_02;

class Buyer extends Thread implements IBuyer {

    Buyer(int number) {
        super("Buyer № " + number);
        Dispatcher.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout= Util.random(500,2000);
        Util.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void goToQueue() {
        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                System.out.println(this+" is wait.");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " out from market");
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
