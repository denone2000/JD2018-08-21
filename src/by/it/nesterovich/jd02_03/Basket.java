package by.it.nesterovich.jd02_03;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

class Basket {

    private final Buyer nameBuyer;
    private HashMap<String, Integer> basket = new HashMap<>();
    private ArrayBlockingQueue<Buyer> arrayBlockingQueue = new ArrayBlockingQueue<>(20);

    Basket(Buyer nameBuyer) {
        this.nameBuyer = nameBuyer;
    }

    void addGoodsInBasket(String good, Integer price) {
        basket.put(good, price);
    }

    HashMap<String, Integer> getBasket() {
        return basket;
    }

    void takeBasket() {
        try {
            arrayBlockingQueue.put(nameBuyer);
            System.out.println(nameBuyer + " взял корзину. Всего взято корзин: " + arrayBlockingQueue.size() + "<<<<<<<");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void returnBasket() {
        try {
            arrayBlockingQueue.take();
            System.out.println(nameBuyer + " вернул корзину. Всего взято корзин: " + arrayBlockingQueue.size() + "<<<<<<<");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
