package by.it.bindyuk.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Bucket {

    private Map<String, Double> bucketWithPrice = new HashMap<>();

    void putGoodWithPrice(Map.Entry<String, Double> entry) {
        bucketWithPrice.put(entry.getKey(), entry.getValue());
    }

    Map<String, Double> getChoosenGoodsWithPrice() {
        return bucketWithPrice;
    }

    void clearBucket(){
        for (int i = 0; i <bucketWithPrice.size()-1 ; i++) {
            Set<Map.Entry<String, Double>> key = bucketWithPrice.entrySet();
            for (Map.Entry<String, Double> entry : key) {
                bucketWithPrice.remove(entry.getKey(),entry.getValue());
            }
        }
    }
}
