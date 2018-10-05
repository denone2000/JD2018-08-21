package by.it.bindyuk.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Goods {
    private static Map<String, Double> goods = new HashMap<>();

    static {
        Goods.goods.put("Bread", 1.5);
        Goods.goods.put("Salt", 2.0);
        Goods.goods.put("Potatoes", 3.5);
        Goods.goods.put("Chocolate", 2.0);
        Goods.goods.put("Tomatoes", 4.3);
        Goods.goods.put("Carrot", 3.6);
        Goods.goods.put("Water", 0.7);
        Goods.goods.put("Beer", 2.5);
        Goods.goods.put("Meat", 10.7);
        Goods.goods.put("Apple", 5.2);
        addGood("Chips",2.2);
        addGood("Rice",0.9);
    }

    private static Map<String, Double> getAllGoods() {
        return goods;
    }

    private static void addGood(String name, double price) {
        goods.put(name, price);
    }

    private static void removeGood(String name, double price) {
        goods.remove(name, price);
    }

    static Map.Entry<String, Double> getRandomGoodWithPrice() {
        int random = Utils.random(0, goods.size() - 1);
        int buff = 0;
        for (Map.Entry<String, Double> entry : goods.entrySet()) {
            if (buff == random) {
                return entry;
            }
            buff++;
        }
        return null;
    }
}