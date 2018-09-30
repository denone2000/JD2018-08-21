package by.it.galushka.draft.executorsDemo;

import java.util.concurrent.ExecutorService;

public class ExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService executors = java.util.concurrent.Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            executors.execute(new ExecutorsRun(i));
        }
        executors.shutdown();
    }
}
