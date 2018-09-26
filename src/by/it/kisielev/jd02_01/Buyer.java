package by.it.kisielev.jd02_01;

class Buyer extends Thread implements IBuyer {

    Buyer(int number){super("Buyer#"+number);}

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        Dispathcer.addBuyer();
        System.out.println(this+"entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"started to choose goods");
        int timeout= Util.random(500,2000); // создаем таймер для покупок
        Util.sleep(timeout);
        System.out.println(this+"finished to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this+"go out from market");
        Dispathcer.removeBuyer();
    }
    @Override
    public String toString(){return this.getName();}
}
