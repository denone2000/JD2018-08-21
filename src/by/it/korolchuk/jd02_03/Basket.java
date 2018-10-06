package by.it.korolchuk.jd02_03;

import java.util.*;


class Basket {

    private Map<String, Double> someBasket = new HashMap<>();

    void putGood(Map.Entry<String, Double> entry) {

        someBasket.put(entry.getKey(), entry.getValue());
    }

   Map<String, Double> putGoodOut() {

        return someBasket;
    }

    static void clear(Map<String, Double> basket){

        basket.clear();
    }

}
