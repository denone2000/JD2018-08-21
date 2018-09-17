package by.it.galushka.calc;

import java.util.*;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static String printVar(){
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Var>> entries = Var.vars.entrySet();
        Iterator<Map.Entry<String, Var>> i = entries.iterator();
        while(i.hasNext()){
            sb.append(i.next().toString()).append("\n");
        }
        return sb.toString();
    }

    static Var createVar(String inputLine) {
        inputLine = inputLine.trim();
        if (inputLine.matches(Patterns.SCALAR)) {
            return new Scalar(inputLine);
        }
        else if (inputLine.matches(Patterns.VECTOR)) {
            return new Vector(inputLine);
        }
        else if (inputLine.matches(Patterns.MATRIX)) {
            return new Matrix(inputLine);
        }
        else if (vars.containsKey(inputLine))
            return vars.get(inputLine);
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+this+" + "+other+" невозможна!");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычетания "+this+" - "+other+" невозможна!");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения "+this+" * "+other+" невозможна!");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+this+" / "+other+" невозможна!");
        return null;
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }
}
