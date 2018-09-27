package by.it.kuzmich.jd01.jd01_01;

public class Main {
    public static void main(String[] args) {
        System.out.println("HeloWorld");
        Hello hello = new Hello();
        hello.printSlogan();
        Args argsObject = new Args(args);
        argsObject.printArgs();
        hello.setSlogan("Привет мир!");
        hello.printSlogan();
    }
}
