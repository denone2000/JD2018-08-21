package by.it.yarmolenka.jd01_01;

public class Main {

    public static void main(String[] args) {

        //создаем экземпляр класса

        Hello hello=new Hello();

        //и используем два экземплярных метода

        hello.printSlogan();
        hello.setSlogan("Привет Мир!");
        hello.printSlogan();

        //покажем аргументы

        Args argObj=new Args(args);
        argObj.printArgs();
    }
}
