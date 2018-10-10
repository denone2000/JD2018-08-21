package by.it.korolchuk.jd02_05.Calc_jd02_05;

import java.util.HashMap;
import java.util.Map;

public class Var implements Operation, Str{

    CalcLogger logger = CalcLogger.getInstance();
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
        System.out.println(MSG_ADD_IMPOSSIBLE);
        logger.log(MSG_ADD_IMPOSSIBLE);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println(MSG_SUB_IMPOSSIBLE);
        logger.log(MSG_SUB_IMPOSSIBLE);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println(MSG_MUL_IMPOSSIBLE);
        logger.log(MSG_MUL_IMPOSSIBLE);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println(MSG_DIV_IMPOSSIBLE);
        logger.log(MSG_DIV_IMPOSSIBLE);
        return null;
    }
}
