package by.it.voinilo.jd02.jd02_01;

public class Market {
    public static void main(String[] args) {
        Buyer buyer1 = new Buyer(1);
        Buyer buyer2 = new Buyer(2);
        buyer1.start();
        buyer2.start();
    }
}
