package by.it.nesterovich.jd02_06.calc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static void saveVar(String name, Var var) {
        vars.put(name, var);
    }

    static void printVar() {
        if (vars.isEmpty()) {
            System.out.println(Res.INSTANCE.get(StrConst.NO_VARIABLES_IN_THE_LIST));
        } else {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }

    static void sortVar() {
        if (vars.isEmpty()) {
            System.out.println(Res.INSTANCE.get(StrConst.NO_VARIABLES_IN_THE_LIST));
        } else {
            HashMap<String, Var> varsSort = new HashMap<>();
            varsSort.putAll(vars);
            for (Map.Entry<String, Var> entry : varsSort.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }

    static Var createVar(String operand) throws CalcException {
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
        Logger.getInstance().log(Res.INSTANCE.get(StrConst.UNABLE_TO_CREATE) + " " + operand);
        throw new CalcException(Res.INSTANCE.get(StrConst.UNABLE_TO_CREATE) + " " + operand);
    }

    @Override
    public Var add(Var other) throws CalcException, IOException {
        Logger.getInstance().log(Res.INSTANCE.get(StrConst.ADDITION_OPERATION) + this + "+" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
        throw new CalcException(Res.INSTANCE.get(StrConst.ADDITION_OPERATION) + this + "+" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
    }

    @Override
    public Var sub(Var other) throws CalcException, IOException {
        Logger.getInstance().log(Res.INSTANCE.get(StrConst.SUBTRACTION_OPERATION) + this + "-" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
        throw new CalcException(Res.INSTANCE.get(StrConst.SUBTRACTION_OPERATION) + this + "-" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        Logger.getInstance().log(Res.INSTANCE.get(StrConst.MULTIPLICATION_OPERATION) + this + "*" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
        throw new CalcException(Res.INSTANCE.get(StrConst.MULTIPLICATION_OPERATION) + this + "*" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
    }

    @Override
    public Var div(Var other) throws CalcException {
        Logger.getInstance().log(Res.INSTANCE.get(StrConst.DIVISION_OPERATION) + this + "/" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
        throw new CalcException(Res.INSTANCE.get(StrConst.DIVISION_OPERATION) + this + "/" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
    }

    @Override
    public String toString() {
        return Res.INSTANCE.get(StrConst.THIS_CLASS_VAR);
    }
}
