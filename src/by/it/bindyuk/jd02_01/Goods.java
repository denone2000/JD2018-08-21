package by.it.bindyuk.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Goods {
    static Map<String, Double> goods = new HashMap<>();

    static String getRandomGood() {
        int random = Utils.random(0, goods.size() - 1);
        int buff = 0;
        for (String randomGood : goods.keySet()) {
            if (buff == random) {
                return randomGood;
            }
            buff++;
        }
        return null;
    }
}