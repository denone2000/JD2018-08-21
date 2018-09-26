package by.it.bindyuk.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private Bucket bucket;

    Buyer(int number) {
        super("Buyer № " + number);
    }

    @Override
    public void enterToMarket() {
        Dispatcher.addBuyer();
        System.out.println(this + " entered to the market");
    }

    @Override
    public void takeBacket() {
        this.bucket = new Bucket();
        Utils.sleep(Utils.random(100, 200));
        System.out.println(this + " put the Backet");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        for (int i = 0; i < Utils.random(1, 4); i++) {
            String chooseGood = Goods.getRandomGood();
            bucket.putGood(chooseGood);
            System.out.println(this + " choose the " + chooseGood);
            Utils.sleep(Utils.random(100, 200));
        }
        Utils.sleep(Utils.random(500, 2000));
        System.out.println(this + " ended to choose goods");
        System.out.println("In " + this + " bucket's: " + bucket.getChosenGoods());
    }

    @Override
    public void putGoodsToBacket() {
        Utils.sleep(Utils.random(100, 200));
        System.out.println(this + " put good to backet");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    @Override
    public void goOut() {
        System.out.println(this + " went out the Market");
        Dispatcher.subBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

