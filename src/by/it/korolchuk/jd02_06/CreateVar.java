package by.it.korolchuk.jd02_06;

public class CreateVar {
    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) return  new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        if (Var.vars.containsKey(strVar)) return Var.vars.get(strVar);
        //TODO add exception create vars
        return null;
    }
    static Var createVar(double number) {
        return new Scalar(number);
    }

    static Var createVar(double[] number) {
        return new Vector(number);
    }

    static Var createVar(double[][] number) {
        return new Matrix(number);
    }
}
