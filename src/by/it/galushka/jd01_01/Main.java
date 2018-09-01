package by.it.galushka.jd01_01;

public class Main {

    public static void main(String[] args) {

        Hello hello=new Hello();
        hello.printText();
        hello.setText("Привет мир!");
        hello.printText();

        Args argObj=new Args(args);
        argObj.printArgs();
    }
}
