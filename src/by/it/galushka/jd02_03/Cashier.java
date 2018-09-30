package by.it.galushka.jd02_03;

public class Cashier implements Runnable {

    private int numberCahier;

    public Cashier(int num) {
        this.numberCahier = num;
    }

    @Override
    public void run() {
        System.out.println(this + " started.");
        while (!Dispatcher.planCompleted()) {
            Buyer buyer = Queue.pollBuyerFromQueue();
            if (buyer != null) {
                startService(buyer);
            } else {
                Util.sleep(100);
            }
        }
        System.out.println(this + " ended work today.");
    }

    private void startService(Buyer buyer){
        System.out.println(this + " started service " + buyer + ".");
        System.out.println("    Total buyers in queue: " + Queue.getQueueSize() + ".");
        Util.sleep(Util.getRandom(2000, 5000));
        System.out.println(this + " ended service " + buyer + ".");
        synchronized (buyer) {
            buyer.notify();
        }
    }

    @Override
    public String toString() {
        return "Cashier №" + numberCahier;
    }
}
