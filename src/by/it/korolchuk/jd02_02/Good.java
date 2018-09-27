package by.it.korolchuk.jd02_02;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Good {

    private static Map<String, Double> goodsMap = new HashMap<>();

    static {
        goodsMap.put("кофе", 15.50);
        goodsMap.put("чай", 6.20);
        goodsMap.put("молоко", 1.80);
        goodsMap.put("печенье", 5.00);
    }

    static Set<String> goodsKeySet() {
        return goodsMap.keySet();
    }
}

