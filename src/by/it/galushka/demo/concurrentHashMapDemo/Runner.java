package by.it.galushka.demo.concurrentHashMapDemo;

public class Runner {
    public static void main(String[] args) {
        for (int i = 1; i <= 3 ; i++) {
            Buyer buyer = new Buyer(i);
            buyer.start();
        }
    }
}
