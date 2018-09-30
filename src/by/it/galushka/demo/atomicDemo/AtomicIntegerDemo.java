package by.it.galushka.demo.atomicDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(0);
        atomic.incrementAndGet();
        System.out.println("incr: " + atomic);
        atomic.incrementAndGet();
        System.out.println("incr: " + atomic);
        atomic.decrementAndGet();
        System.out.println("decr: " + atomic);
        int i = atomic.get();
        System.out.println("get(): " + i);
    }
}
