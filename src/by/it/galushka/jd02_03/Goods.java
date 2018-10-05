package by.it.galushka.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Goods {

    private static Map<String, Double> mapGoods = putMapGoods();

    private static Map<String, Double> putMapGoods() {
        Map<String, Double> map = new HashMap<>();
        map.put("bread", 1.50);
        map.put("milk", 0.90);
        map.put("cheese", 2.00);
        map.put("chips", 3.50);
        map.put("chiсken", 4.20);
        map.put("eggs", 1.00);
        map.put("olive", 3.00);
        map.put("ice-cream", 1.20);
        return map;
    }

    static Map<String, Double> getRandomGood() {
        Map<String, Double> result = new HashMap<>();
        List<String> list = new ArrayList<>(mapGoods.keySet());
        String key = list.get(Util.getRandom(7));
        result.put(key, mapGoods.get(key));
        return result;
    }

    static String getGoodName(Map<String, Double> map) {
        String goodName = "";
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            goodName = entry.getKey();
        }
        return goodName;
    }

    static double getGoodCost(Map<String, Double> map) {
        double goodCost = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            goodCost = entry.getValue();
        }
        return goodCost;
    }
}
