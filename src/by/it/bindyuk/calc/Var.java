package by.it.bindyuk.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
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

    public static Map<String, Var> getVars() {
        return vars;
    }

    private static Map<String,Var> vars = new HashMap<>();
    static Var saveVars (String name, Var var){
        vars.put(name,var);
        return var;
    }

    static Var createVar(String strVar) {
        strVar = strVar.trim();
        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        else if (vars.containsKey(strVar)) return vars.get(strVar);
        else return null;
    }

}