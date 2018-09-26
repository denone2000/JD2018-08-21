package by.it.korolchuk.jd02_01;


import java.util.*;

import static by.it.korolchuk.jd02_01.Util.*;

public class Goods {


   /* private static Map<String, Double> createGoodsMap;

    static {
        Map<String, Double> goods = new HashMap<>();
        goods.put("кофе", 15.50);
        goods.put("чай", 6.20);
        goods.put("молоко", 1.80);
        goods.put("печенье", 5.00);
        List<String> keys = new ArrayList<>(goods.keySet());
    }*/



    static void addGoods() {

        Map<String, Double> basket = new HashMap<>();
        Map<String, Double> goods = new HashMap<>();
        goods.put("кофе", 15.50);
        goods.put("чай", 6.20);
        goods.put("молоко", 1.80);
        goods.put("печенье", 5.00);

        List<String> keys = new ArrayList<>(goods.keySet());
        Double value;
        String randomKey;
        for (int i = 0; i < random(keys.size()); i++) {
            randomKey = keys.get(random(keys.size()));  //Тут вылетает IndexOutOfBounds
            basket.put(randomKey, value = goods.get(randomKey));
        }

        for(Map.Entry<String, Double> pair : basket.entrySet())
        {
            String key = pair.getKey();
            value = pair.getValue();
            System.out.println(key + " " + value);
        }

    }
}
