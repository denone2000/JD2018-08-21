package by.it.galushka.jd02_03;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Check {

    static void printCheck(Buyer buyer, Map<String, Double> goodsMap) {
        StringBuilder check = new StringBuilder();
        Set<Map.Entry<String, Double>> entries = goodsMap.entrySet();
        check.append("$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
        check.append("\t" + buyer + " check:\n");
        check.append("\t------------------\n");
        for (Map.Entry<String, Double> entry : entries) {
            String key = entry.getKey();
            Double value = entry.getValue();
            check.append("\t").append(key).append("\t= ").append(value).append("\n");
        }
        check.append("\t------------------\n");
        check.append("\tTotal cost: " + getTotalCost(goodsMap)+"\n");
        check.append("$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(check);
    }

    static void addCost(String good, double cost, ConcurrentHashMap<String, Double> goodsMap) {
        double actualCost = goodsMap.get(good);
        Set<Map.Entry<String, Double>> entries = goodsMap.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getKey().equals(good)) {
                entry.setValue(actualCost + cost);
                break;
            }
        }
    }

    private static double getTotalCost(Map<String, Double> map) {
        double sum = 0;
        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            sum += entry.getValue();
        }
        return sum;
    }

//    static void printCheck(Buyer buyer, ConcurrentHashMap<String, Double> goodsMap) {
//        Set<Map.Entry<String, Double>> entries = goodsMap.entrySet();
//        System.out.println(buyer + " end choosing goods today.");
//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
//        System.out.println("\t" + buyer + " check:");
//        System.out.println("\t------------------");
//        System.out.printf("\t%-10s == %4s\n", "Goods name", "Cost");
//        System.out.println("\t------------------");
//        for (Map.Entry<String, Double> entry : entries) {
//            String key = entry.getKey();
//            Double value = entry.getValue();
//            System.out.printf("\t%-10s == %3.2f\n", key, value);
//        }
//        System.out.println("\t------------------");
//        System.out.printf("\tTotal cost: %-5.2f\n" , getTotalCost(goodsMap));
//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
//    }
}
