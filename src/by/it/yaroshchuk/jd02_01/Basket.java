package by.it.yaroshchuk.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private static Map<String, Double> goodsInBasket = new HashMap<>();

    static void addGoodInBasket(String key, Double value){
        goodsInBasket.put(key, value);
    }
}
