package by.it.artemliashkov.jd02_01;

public class Market {
    public static void main(String args[])
    {


        int counterBuyer=0;
        int basketBuyer=0;

        for (int currentSeconds = 0; currentSeconds <120 ; currentSeconds++) {
            for (int i = 0; i <Util.random() ; i++) {
                Buyer buyer=new Buyer(++counterBuyer);
                buyer.start();
                UseBasket useBasket=new UseBasket(++basketBuyer);
                useBasket.start();
                try {
                    Thread.sleep(1000/Discpathcer.SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
