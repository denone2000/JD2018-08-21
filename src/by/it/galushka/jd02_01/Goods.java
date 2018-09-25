package by.it.galushka.jd02_01;

import java.lang.reflect.Array;
import java.util.*;

class Goods {

    private static Map<String, Double> mapGoods = putMapGoods();

    static Map<String, Double> putMapGoods() {
        Map<String, Double> map = new HashMap<>();
        map.put("bread", 1.5);
        map.put("milk", 0.9);
        map.put("cheese", 2.0);
        map.put("chips", 3.5);
        map.put("chiсken", 4.2);
        map.put("eggs", 1.0);
        map.put("olive", 3.0);
        map.put("ice-cream", 1.2);
        return map;
    }

    static Map<String, Double> getMapGoods() {
        return mapGoods;
    }

    static Map<String, Double> getRandomGoods() {
        Map<String, Double> result = new HashMap<>();
        List<String> list = new ArrayList<>(mapGoods.keySet());
        String key = list.get(Util.getRandom(7));
//        String[] keys = new String[entries.size()];
//        int counterKeys = 0;
//        for (Map.Entry<String, Double> entry : entries) {
//            keys[counterKeys] = entry.getKey();
//            counterKeys++;
////        }
//        String key = keys[Util.getRandom(8)];
//        mapGoods.get(key).
//        return result;
        result.put(key, mapGoods.get(key));
        return result;
    }

    //===============================================================
    // main для проверки метода
    public static void main(String[] args) {
        Map<String, Double> randomGoods = new HashMap<>();
//        System.out.println(randomGoods);
        for (int i = 0; i <4; i++) {
            randomGoods.putAll(getRandomGoods());
        }
        System.out.println(randomGoods);
    }
//===============================================================
}
