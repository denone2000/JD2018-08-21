package by.it.yaroshchuk.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Basket {

    private  Map<String, Double> goodsInBasket = new HashMap<>();

    void addGoodInBasket(String key, Double value){
        goodsInBasket.put(key, value);
    }

    Map<String, Double> getGoodsInBacket(){
        return goodsInBasket;
    }

    double totalPrice(){
        double total = 0;
        for (Map.Entry<String, Double> stringDoubleEntry : goodsInBasket.entrySet()) {
            total += stringDoubleEntry.getValue();
        }
        return total;
    }
}
