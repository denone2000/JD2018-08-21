package by.it.yaroshchuk.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static void saveVar(String name, Var var){
        vars.put(name, var);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления невозможна");
    }

    public static Var createVar(String strVar){
        if(strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        if(strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        if(strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        Var result = vars.get(strVar);
        //TODO add exception create vars
        return result;
    }

    @Override
    public String toString() {
        return "Var{}";
    }
}
