package by.it.bindyuk.jd02_06.calcV3;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) throws CalcException {
        ConsoleRunner.logger.log(ConsoleRunner.res.getKeys
                (Messages.MSG_OPERATION_ADD) + this + " + " + other + ConsoleRunner.res.getKeys
                (Messages.MSG_INCREDIBLE));
        throw new CalcException(ConsoleRunner.res.getKeys
                (Messages.MSG_OPERATION_ADD) + this + " + " + other + ConsoleRunner.res.getKeys
                (Messages.MSG_INCREDIBLE));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        ConsoleRunner.logger.log(ConsoleRunner.res.getKeys
                (Messages.MSG_OPERATION_SUB) + this + " - " + other + ConsoleRunner.res.getKeys
                (Messages.MSG_INCREDIBLE));
        throw new CalcException(ConsoleRunner.res.getKeys
                (Messages.MSG_OPERATION_SUB) + this + " - " + other + ConsoleRunner.res.getKeys
                (Messages.MSG_INCREDIBLE));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        ConsoleRunner.logger.log(ConsoleRunner.res.getKeys
                (Messages.MSG_OPERATION_MUL) + this + " * " + other + ConsoleRunner.res.getKeys
                (Messages.MSG_INCREDIBLE));
        throw new CalcException(ConsoleRunner.res.getKeys
                (Messages.MSG_OPERATION_MUL) + this + " * " + other + ConsoleRunner.res.getKeys
                (Messages.MSG_INCREDIBLE));
    }

    @Override
    public Var div(Var other) throws CalcException {
        ConsoleRunner.logger.log(ConsoleRunner.res.getKeys
                (Messages.MSG_OPERATION_DIV) + this + " / " + other + ConsoleRunner.res.getKeys
                (Messages.MSG_INCREDIBLE));
        throw new CalcException(ConsoleRunner.res.getKeys
                (Messages.MSG_OPERATION_DIV) + this + " / " + other + ConsoleRunner.res.getKeys
                (Messages.MSG_INCREDIBLE));
    }

    public static Map<String, Var> getVars() {
        return vars;
    }

    public static Map<String, Var> vars = new HashMap<>();

    static Var saveVars(String name, Var var) {
        vars.put(name, var);
        return var;
    }

//    static Var createVar(String strVar) throws CalcException {
//        strVar = strVar.trim();
//        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
//        if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
//        if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
//        if (vars.containsKey(strVar)) return vars.get(strVar);
//
//        ConsoleRunner.logger.log(ConsoleRunner.res.getKeys(Messages.ERROR_VARIABLE) + strVar);
//        throw new CalcException(ConsoleRunner.res.getKeys(Messages.ERROR_VARIABLE) + strVar);
//    }

}