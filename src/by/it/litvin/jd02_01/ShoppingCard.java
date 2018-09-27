package by.it.litvin.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCard {
    public static final Map<Good, Integer> map;

    static {
        map = new HashMap<>();
        map.put(new Good("Яблоко"), 1);
        map.put(new Good("Груша"), 2);
        map.put(new Good("Вишня"), 3);
        map.put(new Good("Апельсин"), 4);

    }
}
