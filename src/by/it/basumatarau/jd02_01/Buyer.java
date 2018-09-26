package by.it.basumatarau.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private Basket basket = null;
    private final boolean isPensioneer = Util.random(3)==3;
    private final double BUYER_KSPEED = isPensioneer? 1.5:1.0;

    Buyer(int customerNumber){
        super("Customer#"+customerNumber);
    }

    @Override
    public void takeBasket() {

        Util.sleep(Util.random((int)(100* BUYER_KSPEED),(int) (200* BUYER_KSPEED)));
        this.basket = new Basket();
        System.out.println(getName()+" took a basket");
    }

    @Override
    public void putGoodsToBasket() {
        for (int i = 0; i < Util.random(1,4); i++) {
            Util.sleep(Util.random((int)(100* BUYER_KSPEED),(int) (200* BUYER_KSPEED)));

            int dice = Util.random(0, Good.getGoods().size()-1);
            int iterator = 0;
            for (String good : Good.getGoods()) {
                if (dice==iterator++){
                    basket.addGood(good);
                    System.out.println(getName()+" has put "+good+" in the basket");
                }
            }
        }
        System.out.println(getName()+" proceeds to checkout with "+basket.getGoods()+" in the basket");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(getName()+" entered market");
    }

    /**
     *
     * время жизни треда увеличино чтобы позволить экземплярам треда Buyer накапливаться
     * чтобы протестировать регулирование численности акивных потоков (экземпляров Buyer)
     * */
    @Override
    public void chooseGoods() {
        Util.sleep(Util.random((int)(35000* BUYER_KSPEED), (int)(40000* BUYER_KSPEED)));
        System.out.println(getName()+" has chosen some goods");
    }

    @Override
    public void goOut() {
        System.out.println(getName()+" has gone out");
    }

    @Override
    public String toString() {
        return getName();
    }
}
