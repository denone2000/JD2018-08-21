package by.it.artemliashkov.jd02_01;

public class Buyer extends Thread implements IBuyer {

    private boolean pensioner;
    private static final  double delta=150;

    Buyer(int number) {
        super("Покупатель №"+number);
        this.pensioner = number % 4 == 0;
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
            if (pensioner) {
                sleep((int) (delta*(500+Math.random()*1501)));
            }
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
