package by.it.korzik.calc;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {
    private static Map<String, Var> vars=new HashMap<>();

    static void saveVar(String name, Var var){
        vars.put(name,var);
    }

    static Var createVar(String operand) throws CalcException {
        operand=operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR)){
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)){
            return new Vector(operand);
        }
        Var result=vars.get(operand);
        if (result==null)
            throw  new CalcException("Нет такой переменной "+ operand);
        return result;
    }
    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения невозможна!");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания невозможна!");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения невозможна!");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления невозможна!");
    }
}
