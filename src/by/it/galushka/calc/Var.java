package by.it.galushka.calc;

import java.util.*;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static String printVar() {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Var>> entries = Var.vars.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            sb.append(entry.toString()).append("\n");
        }
        return sb.toString();
    }

    static Var createVar(String inputLine) throws CalcException {
        inputLine = inputLine.trim();
        if (inputLine.matches(Patterns.SCALAR)) {
            return new Scalar(inputLine);
        } else if (inputLine.matches(Patterns.VECTOR)) {
            return new Vector(inputLine);
        } else if (inputLine.matches(Patterns.MATRIX)) {
            return new Matrix(inputLine);
        } else if (vars.containsKey(inputLine))
            return vars.get(inputLine);
        throw new CalcException("Невозможно создать " + inputLine);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + " + " + other + " невозможна!");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычетания " + this + " - " + other + " невозможна!");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + " * " + other + " невозможна!");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + " / " + other + " невозможна!");
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }
}
