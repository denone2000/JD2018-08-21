package by.it.bindyuk.jd02_03;

public class Market {
    static BucketCollect bucketCollect = new BucketCollect();
    public static void main(String[] args) {



        Controller controller = new Controller();
        controller.start();

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
        try {
            controller.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Controller.executors.shutdown();
        while (!Controller.executors.isTerminated()) {
            Utils.sleep(10);
        }
        System.out.println("Now in Market: " + Dispatcher.getBuyersInMarket());
        System.out.println("Market was closed");
    }
}
