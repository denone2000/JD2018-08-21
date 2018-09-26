package by.it.artemliashkov.jd02_01;

public class Buyer extends Thread implements IBuyer {

    Buyer(int number) {
        super("Покупатель №"+number);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" Вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        try {
            System.out.println(this+ "начал выбирать товары");
            sleep((int)(500+Math.random()*1501));
        } catch (InterruptedException e) {
            System.out.println(this+ "закончил выбирать товары");
            e.printStackTrace();
        }

    }



    public String toString()
    {
        return this.getName();
    }

    public void run()
    {
        enterToMarket();
        chooseGoods();
        goOut();
    }
    @Override
    public void goOut()
    {
        System.out.println(this+" вышел из магазина");
    }
}
