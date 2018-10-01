package by.it.korzik.jd02_03;

public class Cashier implements Runnable{

    private static volatile int number;

    public Cashier(int num){
        number = num;
    }

    @Override
    public void run() {
        System.out.println(this+" начал работу");
        while(!Util.planComplete()){
            Buyer buyer = BuyersQueue.pollBuyer();
            if (buyer != null) {
                int timeout = Util.random(2000, 5000);
                System.out.println(this + " начал обслуживание " + buyer.getName());
                Util.sleep(timeout);
                System.out.println(this + " закончил обслуживание " + buyer.getName());
                synchronized
                        (buyer){
                    buyer.notify();
                }
            } else {
                Util.sleep(100);
            }
            synchronized (Util.class){
            Util.plan.addAndGet(1);}
        }
        System.out.println(this+" закончил работу");
    }


    @Override
    public String toString() {
        return "Кассир№"+number;
    }
}
