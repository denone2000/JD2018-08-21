package by.it.bindyuk.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Goods {
    static Map<String, Double> goods = new HashMap<>();

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