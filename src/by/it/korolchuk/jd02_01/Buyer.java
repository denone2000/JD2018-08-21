package by.it.korolchuk.jd02_01;

public class Buyer extends  Thread implements IBuyer{

    @Override
    public String toString() {
        return this.getName();
    }

    public Buyer (int number) {
        super("Покупатель № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
        Dispatcher.addBuyer();
    }

    @Override
    public void chooseGoods() {
        try {
            System.out.println(this + " начал выбирать товары");
            int timeout = Util.random(500, 2000);
            sleep((int)(Math.random()*1501));

            System.out.println(this + " закончил выбирать товары");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @Override
    public void goOut() {
        Dispatcher.removeBuyer();
        System.out.println(this + " вышел из магазина");
    }
}
