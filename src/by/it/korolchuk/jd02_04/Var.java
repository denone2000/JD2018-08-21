package by.it.korolchuk.jd02_04;

import java.util.HashMap;
import java.util.Map;

public class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();
    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) return  new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        if (vars.containsKey(strVar)) return vars.get(strVar);
        //TODO add exception create vars
        return null;
    }

    @Override
    public Var add(Var other) {
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
}
