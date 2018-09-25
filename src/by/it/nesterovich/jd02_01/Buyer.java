package by.it.nesterovich.jd02_01;

class Buyer extends Thread implements IBuyer {

    Buyer(int number) {
        super("Buyer № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        Dispatcher.addBuyer();
        System.out.println(this + " entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " out from market");
        Dispatcher.removeBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
