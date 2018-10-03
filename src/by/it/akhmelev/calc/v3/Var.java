package by.it.akhmelev.calc.v3;

import by.it.akhmelev.calc.v3.*;
import by.it.akhmelev.calc.v3.CalcException;
import by.it.akhmelev.calc.v3.Matrix;
import by.it.akhmelev.calc.v3.Patterns;
import by.it.akhmelev.calc.v3.Scalar;
import by.it.akhmelev.calc.v3.Vector;

import java.util.HashMap;
import java.util.Map;

class Var implements by.it.akhmelev.calc.v3.Operation {

    private static Map<String, Var> vars=new HashMap<>();

    static void saveVar(String name, Var var){
        vars.put(name,var);
    }


    @Override
    public Var add(Var other) throws by.it.akhmelev.calc.v3.CalcException {
        throw  new by.it.akhmelev.calc.v3.CalcException("Операция сложения невозможна");
    }

    @Override
    public Var sub(Var other) throws by.it.akhmelev.calc.v3.CalcException {
        throw  new by.it.akhmelev.calc.v3.CalcException("Операция вычитания невозможна");
    }

    @Override
    public Var mul(Var other) throws by.it.akhmelev.calc.v3.CalcException {
        throw  new by.it.akhmelev.calc.v3.CalcException("Операция умножения невозможна");
    }

    @Override
    public Var div(Var other) throws by.it.akhmelev.calc.v3.CalcException {
        throw  new by.it.akhmelev.calc.v3.CalcException("Операция деления невозможна");
    }

    static Var createVar(String strVar) throws by.it.akhmelev.calc.v3.CalcException {
        //2 {1,2,3,4} {{1,2},{3,4}}
        if (strVar.matches(by.it.akhmelev.calc.v3.Patterns.SCALAR)) return new by.it.akhmelev.calc.v3.Scalar(strVar);
        if (strVar.matches(by.it.akhmelev.calc.v3.Patterns.VECTOR)) return new by.it.akhmelev.calc.v3.Vector(strVar);
        if (strVar.matches(Patterns.MATRIX)) return new by.it.akhmelev.calc.v3.Matrix(strVar);
        Var result=vars.get(strVar);
        if (result==null)
            throw  new CalcException("Нет такой переменной "+strVar);
        return result;

    }
}
