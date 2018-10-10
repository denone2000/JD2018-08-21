package by.it.voinilo.jd02.jd02_02;



public class Cashier extends Thread implements Runnable {
private String name;
    public Cashier(int number) {
        name = "Cashier №" + number + " ";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Buyer b =  QueueBuyers.extract();
        while ((b=QueueBuyers.extract())!=null){
            System.out.println(this + " обслуживается" + b);
                int timeout =(Custom.rndAtoB(2000,5000));
                        try {Thread.sleep(timeout);} catch (InterruptedException e) { e.printStackTrace();}
            synchronized (b){b.notify();}

            System.out.println(this + "завершил обслуживание для "+ b);
        }
    }
}
