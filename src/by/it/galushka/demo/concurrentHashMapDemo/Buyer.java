package by.it.galushka.demo.concurrentHashMapDemo;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Buyer extends Thread {

    public Buyer(int number) {
        super("Bueyr" + number);
    }

    @Override
    public void run() {
        chooseGoods();
    }

    public void chooseGoods() {
        ConcurrentHashMap<String, Double> goodsMap = new ConcurrentHashMap<>();
        int quantityGoods = Util.getRandom(1, 4);
        for (int goods = 0; goods < quantityGoods; goods++) {
            System.out.println(this + " start choosing goods.");
            Util.sleep((Util.getRandom(500, 2000)));
            Map<String, Double> choosedGood = Goods.getRandomGood();
            String good = Goods.getGoodName(choosedGood);
            double cost = Goods.getGoodCost(choosedGood);
            if (!goodsMap.containsKey(good))
                goodsMap.putAll(choosedGood);
            else {
                addCost(good, cost, goodsMap);
            }
            System.out.println(this + " choosed " + good + ", cost - " + cost + " rubles.");
            putGoodsToBacket(good);
        }
        System.out.println(this + " end choosing goods today.");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("\t" + this + " check:");
        printCheck(goodsMap);
        System.out.printf("\tTotal cost: %-5.2f\n" , getTotalCost(goodsMap));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    private void printCheck(ConcurrentHashMap<String, Double> goodsMap) {
        Set<Map.Entry<String, Double>> entries = goodsMap.entrySet();
        System.out.println("\t------------------");
        System.out.printf("\t%-10s == %4s\n", "Goods name", "Cost");
        System.out.println("\t------------------");
        for (Map.Entry<String, Double> entry : entries) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.printf("\t%-10s == %3.2f\n", key, value);
        }
        System.out.println("\t------------------");
    }

    private void addCost(String good, double cost, ConcurrentHashMap<String, Double> goodsMap) {
        double actualCost = goodsMap.get(good);
        Set<Map.Entry<String, Double>> entries = goodsMap.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getKey().equals(good)) {
                entry.setValue(actualCost + cost);
                break;
            }
        }
    }

    private void putGoodsToBacket(String good) {
        Util.sleep((Util.getRandom(100, 200)));
        System.out.println(this + " put " + good + " to backet.");
    }

    private static double getTotalCost(ConcurrentHashMap<String, Double> map) {
        double sum = 0;
        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            sum += entry.getValue();
        }
        return sum;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
