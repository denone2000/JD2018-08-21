package by.it.korolchuk.jd02_03;


import java.util.HashMap;
import java.util.Map;

class Good {
    private static Map<String, Double> goodsMap = new HashMap<>();

    static {
        goodsMap.put("coffee", 15.50);
        goodsMap.put("tea", 6.20);
        goodsMap.put("milk", 1.80);
        goodsMap.put("biscuits", 5.00);
    }

    static Map<String, Double> getGoodsMap(){
        return goodsMap;
    }
}

