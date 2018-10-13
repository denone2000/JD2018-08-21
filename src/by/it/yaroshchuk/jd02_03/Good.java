package by.it.yaroshchuk.jd02_03;

import java.util.HashMap;
import java.util.Map;


public class Good {

    static Map<String, Double> goods = new HashMap<>();

    static{
        goods.put("good1", 12.0);
        goods.put("good2", 5.2);
        goods.put("good3", 8.0);
        goods.put("good4", 5.3);
        goods.put("good5", 0.3);
        goods.put("good6", 2.1);
        goods.put("good7", 10.2);
        goods.put("good8", 0.99);
    }

    static Map.Entry<String, Double> getGood(int i){
        for (Map.Entry<String, Double> good : goods.entrySet()) {
            if (i-- == 0)
                return good;
        }
        return null;
    }
}
