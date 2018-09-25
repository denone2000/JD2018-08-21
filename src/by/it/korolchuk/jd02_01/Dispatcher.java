package by.it.korolchuk.jd02_01;
class Dispatcher {
    static final int KoefSpeed = 10;
    private static int buyersInMarket = 0;

    static void addBuyer() {
        buyersInMarket++;
    }

    static void removeBuyer() {
        buyersInMarket--;
    }

   public static int getBuyersInMarket() {
      return buyersInMarket;
   }
}
