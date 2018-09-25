package by.it.galushka.jd02_01;

import java.util.*;

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

    static Map<String, Double> getRandomGoods() {
        Map<String, Double> result = new HashMap<>();
        List<String> list = new ArrayList<>(mapGoods.keySet());
        String key = list.get(Util.getRandom(7));
        result.put(key, mapGoods.get(key));
        return result;
    }

    //===============================================================
    // main для проверки метода
//    public static void main(String[] args) {
//        Map<String, Double> randomGoods = new HashMap<>();
//
//        for (int i = 0; i <4; i++) {
//            randomGoods.putAll(getRandomGoods());
//        }
//        System.out.println(randomGoods);
//    }
//===============================================================
}
