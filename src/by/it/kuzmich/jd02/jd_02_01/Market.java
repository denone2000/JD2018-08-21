package by.it.kuzmich.jd02.jd_02_01;
import java.util.HashMap;
import java.util.Map;

public class Market {
    private static int bcaynter = 0;
    static Map<String,Integer> tovari = new HashMap<>();

    public static void main(String[] args) {
        fillMarket();
        process();
    }

    private static void process() {
        for (int i = 0; i <120 ; i++) {
          int x = Utility.random(2);
            for (int j = 0; j < x; j++) {
                Buyer buyer = new Buyer(++bcaynter);
                buyer.start();
            }
          Utility.sleep(1000);
        }
    }

    private static void fillMarket() {
        tovari.put("Xleb",14);
        tovari.put("Moloko",18);
        tovari.put("Tvorog",42);
        tovari.put("Kartoshka",13);
        tovari.put("Maslo",59);
    }
}
