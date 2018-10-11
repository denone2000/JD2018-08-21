package by.it.yaroshchuk.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static void saveVar(String name, Var var){
        vars.put(name, var);
    }

    @Override
    public Var add(Var other){
        System.out.println("Операция сложения невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления невозможна");
        return null;
    }

    public static Var createVar(String strVar){
        if(strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        if(strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        if(strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        //TODO add exception create vars
        return null;
    }

    @Override
    public String toString() {
        return "Var{}";
    }
}
