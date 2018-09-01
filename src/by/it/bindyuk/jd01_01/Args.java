package by.it.bindyuk.jd01_01;

public class Args {
    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    void printArgs() {
        int i = 1;
        for (String arg : args) {
            System.out.println("Арг №" + i + arg);
            i++;
        }
    }
}
