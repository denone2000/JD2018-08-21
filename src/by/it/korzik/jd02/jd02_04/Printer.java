package by.it.korzik.jd02.jd02_04;

import by.it.korzik.jd02.jd02_04.Var;

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
