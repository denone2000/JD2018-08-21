package by.it.kisielev.jd02_01;

public class Dispathcer {
    static  final int KSPEED =100;
    private static volatile int buyersInMarket =0;
    static void addBuyer() { buyersInMarket++; }
    static void removeBuyer(){ buyersInMarket--;}
    static int getBuyersInMarket() {
        return buyersInMarket;
    }

}
