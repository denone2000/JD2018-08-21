package by.it.korzik.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    private static int buyerCounter = 0;
    static Map<String, Integer> goodsMap = new HashMap<>();

    public static void main(String[] args) {
        fillMap();
        process();
    }

    private static void process() {
        ExecutorService executors = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            executors.execute(cashier);
        }

        for (int i = 0; i < 120; i++) {
                while (Util.marketOpen()) {
                int x = Util.random(2);
                for (int j = 0; j < x; j++) {
                    if (Util.marketOpen()) {
                        Buyer buyer = new Buyer(++buyerCounter);
                        buyer.start();
                    }
                }
                Util.sleep(1000);
            }
        }
        executors.shutdown();
    }

    private static void fillMap() {
        goodsMap.put("Хлеб", 12);
        goodsMap.put("Молоко", 14);
        goodsMap.put("Водичка", 10);
        goodsMap.put("Масло", 17);
        goodsMap.put("Рыба", 17);
        goodsMap.put("Корм для кота", 7);
        goodsMap.put("Корм для собаки", 8);
    }
}
