package by.it.bindyuk.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Bucket {

    private Map<String, Double> bucketWithPrice = new HashMap<>();

    void putGoodWithPrice(Map.Entry<String, Double> entry) {
        bucketWithPrice.put(entry.getKey(), entry.getValue());
    }

    Map<String, Double> getChoosenGoodsWithPrice() {
        return bucketWithPrice;
    }
}
