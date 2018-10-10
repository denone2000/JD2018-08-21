package by.it.basumatarau.jd02_01;

import java.util.HashMap;
import java.util.Set;

class Good {
    private static HashMap<String, Double> merchantGoods = new HashMap<>();
    static {
        merchantGoods.put("tomatoes", 120.0);
        merchantGoods.put("cucumbers", 100.0);
        merchantGoods.put("alcohol1", 140.0);
        merchantGoods.put("potatoes", 200.0);
        merchantGoods.put("bread", 80.0);
        merchantGoods.put("salt", 60.0);
    }
    static Set<String> getGoods(){
        return merchantGoods.keySet();
    }
}
