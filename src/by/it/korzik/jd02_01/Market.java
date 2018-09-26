package by.it.korzik.jd02_01;
import java.util.HashMap;
import java.util.Map;

public class Market {
    private static int buyerCounter = 0;
    static Map<String,Integer> goodsMap = new HashMap<>();

    public static void main(String[] args) {
        fillMap();
        process();
    }

    private static void process() {
        for (int i = 0; i <120 ; i++) {
          int x = Util.random(2);
            for (int j = 0; j < x; j++) {
                Buyer buyer = new Buyer(++buyerCounter);
                buyer.start();
            }
          Util.sleep(1000);
        }
    }

    private static void fillMap() {
        goodsMap.put("Хлеб",12);
        goodsMap.put("Молоко",14);
        goodsMap.put("Водичка",10);
        goodsMap.put("Масло",17);
        goodsMap.put("Рыба",17);
        goodsMap.put("Корм для кота",7);
        goodsMap.put("Корм для собаки",8);
    }
}
