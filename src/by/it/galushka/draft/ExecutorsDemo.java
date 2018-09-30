package by.it.galushka.draft;

import java.util.concurrent.ExecutorService;

public class ExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService executors = java.util.concurrent.Executors.newFixedThreadPool(2);

        executors.shutdown();
    }
}
