package by.it.nesterovich.jd02_06.calc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var getVars(String operand) {
        return vars.get(operand);
    }

    static Map<String, Var> getVars() {
        return vars;
    }

    static void saveVar(String name, Var var) {
        vars.put(name, var);
    }

    static void printVar() {
        if (vars.isEmpty()) {
            Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.NO_VARIABLES_IN_THE_LIST), TitleType.OUTPUT);
            System.out.println(Res.INSTANCE.get(StrConst.NO_VARIABLES_IN_THE_LIST));
        } else {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                Logger.getInstance().writeReport(entry.getKey() + "=" + entry.getValue(), TitleType.OUTPUT);
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }

    static void sortVar() {
        if (vars.isEmpty()) {
            Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.NO_VARIABLES_IN_THE_LIST), TitleType.OUTPUT);
            System.out.println(Res.INSTANCE.get(StrConst.NO_VARIABLES_IN_THE_LIST));
        } else {
            HashMap<String, Var> varsSort = new HashMap<>();
            varsSort.putAll(vars);
            for (Map.Entry<String, Var> entry : varsSort.entrySet()) {
                Logger.getInstance().writeReport(entry.getKey() + "=" + entry.getValue(), TitleType.OUTPUT);
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException, IOException {
        Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.ADDITION_OPERATION) + this + "+" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE), TitleType.ERROR);
        throw new CalcException(Res.INSTANCE.get(StrConst.ADDITION_OPERATION) + this + "+" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
    }

    @Override
    public Var sub(Var other) throws CalcException, IOException {
        Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.SUBTRACTION_OPERATION) + this + "-" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE), TitleType.ERROR);
        throw new CalcException(Res.INSTANCE.get(StrConst.SUBTRACTION_OPERATION) + this + "-" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.MULTIPLICATION_OPERATION) + this + "*" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE), TitleType.ERROR);
        throw new CalcException(Res.INSTANCE.get(StrConst.MULTIPLICATION_OPERATION) + this + "*" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
    }

    @Override
    public Var div(Var other) throws CalcException {
        Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.DIVISION_OPERATION) + this + "/" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE), TitleType.ERROR);
        throw new CalcException(Res.INSTANCE.get(StrConst.DIVISION_OPERATION) + this + "/" + other + Res.INSTANCE.get(StrConst.IMPOSSIBLE));
    }

    @Override
    public String toString() {
        return Res.INSTANCE.get(StrConst.THIS_CLASS_VAR);
    }
}
