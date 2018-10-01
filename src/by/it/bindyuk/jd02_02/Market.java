package by.it.bindyuk.jd02_02;

public class Market {
    public static void main(String[] args) {

        Controller ctrl = new Controller();
        ctrl.setDaemon(true);
        ctrl.start();

        while (Dispatcher.isMarketOpen()) {
            for (int i = 0; i < Utils.random(0, 2); i++) {
                if (Dispatcher.isMarketOpen()) {
                    Buyer buyer = new Buyer(++Controller.counterBuyer);
                    Controller.threads.add(buyer);
                    buyer.start();
                    System.out.println("Now in Market: " + Dispatcher.getBuyersInMarket());
                }
            }
            Utils.sleep(1000);
        }

        for (Thread thread : Controller.threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Now in Market: " + Dispatcher.getBuyersInMarket());
        System.out.println("Market was closed");
    }
}
