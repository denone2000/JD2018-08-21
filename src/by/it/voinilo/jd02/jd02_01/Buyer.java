package by.it.voinilo.jd02.jd02_01;

public class Buyer extends Thread implements IBuyer {

    public Buyer (int number){
        super ("Buyer № " + number );

    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Entered market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        try {
            sleep((int) (500+Math.random()*2001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void goOut() {
        System.out.println(this + "leaved the market");
        try {
            sleep((int) (500+Math.random()*2001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Buyer{}";
    }
}