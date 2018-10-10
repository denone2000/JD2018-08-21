package by.it.korzik.calc;

public class Printer {
    void print(Var var){
        if (var!=null){
        System.out.println(var);
        }
        else {
            System.out.println("ошибочка");
        }
    }
}
