package by.it.kuzmich.jd01.jd01_01;

public class Args {
    public String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    void printArgs() {
        int i = 1;
        for (String arg : args) {
            System.out.println("Arg №" + i + args);
            i++;
        }
    }
}

