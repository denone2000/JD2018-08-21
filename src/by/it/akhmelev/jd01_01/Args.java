package by.it.akhmelev.jd01_01;

public class Args {

    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    void printArgs(){
        int i=1;
        for (String arg : args) {
            System.out.println("Arg №"+i+arg);
            i++;
        }
    }
}
