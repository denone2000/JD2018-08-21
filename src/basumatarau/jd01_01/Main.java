package basumatarau.jd01_01;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Hello hello = new Hello();
        hello.setMoto("Privet lunatikam!");
        hello.printMoto();

        Args argsObject = new Args(args);
        argsObject.printArgs();
    }
}
