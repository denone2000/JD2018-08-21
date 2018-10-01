package by.it.galushka.demo.executorsDemo;

public class ExecutorsRun extends Thread {

    ExecutorsRun(int number) {
        super("Thread №" + number);
    }

    @Override
    public void run() {
        System.out.println(this + " создан.");
        Util.sleep(1000);
        System.out.println(this + " стартовал.");
        Util.sleep(100);
        System.out.println(this + " работает.");
        Util.sleep(Util.getRandom(2000, 5000));
        System.out.println(this + " закончил работу.");
        Util.sleep(100);
        System.out.println(this + " уничтожен.");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
