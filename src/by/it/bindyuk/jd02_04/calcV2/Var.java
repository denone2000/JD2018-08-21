package by.it.bindyuk.jd02_04.calcV2;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + " + " + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + " - " + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "  +this + " * " +other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления "  +this + " / " +other + " невозможна");
    }

    public static Map<String, Var> getVars() {
        return vars;
    }

    public static Map<String, Var> vars = new HashMap<>();

    static Var saveVars(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.trim();
        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        else if (vars.containsKey(strVar)) return vars.get(strVar);
        else return Var.vars.get(strVar);
        //throw  new CalcException("Невозможно создать переменную " + strVar);
    }

}