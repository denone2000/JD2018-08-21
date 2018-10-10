package by.it.yaroshchuk.jd02_02;

import java.util.HashMap;
import java.util.Iterator;
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
        Iterator<Map.Entry<String, Double>> iterator = goodsInBasket.entrySet().iterator();
        while (iterator.hasNext()){
            total += iterator.next().getValue();
        }
        return total;
    }
}
