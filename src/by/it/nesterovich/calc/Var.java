package by.it.nesterovich.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();


    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static void printVar() {
        if (vars.isEmpty()) {
            System.out.println("в списке нет переменных");
        } else {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }

    static void sortVar() {
        if (vars.isEmpty()) {
            System.out.println("в списке нет переменных");
        } else {
            HashMap<String, Var> varsSort = new HashMap<>();
            varsSort.putAll(vars);
            for (Map.Entry<String, Var> entry : varsSort.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }

    static Var createVar(String operand) {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        }
        if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        }
        if (vars.containsKey(operand)) {
            return vars.get(operand);
        }
        //TODO add exception create vars
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + "-" + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + "*" + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + "/" + other + " невозможна");

        return null;
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }
}
