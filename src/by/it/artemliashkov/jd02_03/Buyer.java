package by.it.artemliashkov.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private Map<String, Integer> goods = new HashMap<>();
    HashMap<String, Integer> getBasket() {
        return basket;
    }
    private static Semaphore semaphoreChooseGoods = new Semaphore(20);
    private HashMap<String, Integer> basket = new HashMap<>();
    private boolean pensioner;
    private static final  double delta=150;

    Buyer(int number) {
        super("Покупатель №"+number);
        Discpathcer.addBuyer();
        this.pensioner = number % 4 == 0;
    }

    boolean isPensioner(){
        return pensioner;
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
        goods.put("Молоко", 10000);
        goods.put("Сахар", 7500);
        goods.put("Кефир", 6700);
        goods.put("Йогурт", 3000);
        goods.put("Сыр",47000);
        goods.put("Квас",12000);
        goods.put("Колбаса",30000);
        enterToMarket();
        takeBasket();
        try {
            semaphoreChooseGoods.acquire();
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreChooseGoods.release();
        }
        putGoodsToBasket();
        goQueue();
        goOut();
    }

    private void goQueue() {
        QueueBuyers.addBuyer(this);
        synchronized (this) {
            try {
                System.out.println(this+" ожидает.");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void goOut()
    {
        System.out.println(this+" вышел из магазина");
        Discpathcer.buyerLeaveMarket();
    }

    @Override
    public void takeBasket() {
        try {
            System.out.println(this+ "взял корзину");
            sleep((int)(100+Math.random()*101));
            if (pensioner) {
                sleep((int) (delta*(100+Math.random()*101)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String indexBasket(int arrayGoods) {
        String indexValue;
        switch (arrayGoods) {
            case 1:
                indexValue = "Молоко";
                break;
            case 2:
                indexValue = "Сахар";
                break;
            case 3:
                indexValue = "Кефир";
                break;
            case 4:
                indexValue = "Йогурт";
                break;
            case 5:
                indexValue = "Сыр";
                break;
            case 6:
                indexValue = "Квас";
                break;
            case 7:
                indexValue = "Колбаса";
                break;
            default:
                indexValue = "Incorrect value";
                break;
        }
        return indexValue;
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " started put good to basket");
        for (int i = 0; i < Util.random(1, 4); i++) {
            int arrayGoods=Util.random(1, 7);
            String indexValue= indexBasket(arrayGoods);
            System.out.println(this+ "взял товар");
            for( Map.Entry<String, Integer> entry : goods.entrySet() ){
                if( indexValue.equals( entry.getKey() ) ) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                    basket.put(entry.getKey(), entry.getValue());
                }
            }
            int timeout = Util.random(100, 200);
            if (pensioner) {
                timeout = (int) (1.5 * Util.random(100, 200));
            }
            Util.sleep(timeout);
        }
        System.out.println(this + " finished put good to basket");

    }

}
