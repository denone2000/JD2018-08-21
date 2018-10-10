package by.it.bindyuk.jd02_06.calcV3;

class VarSelector {
    static Var getVar(String strVar) throws CalcException {
        strVar = strVar.trim();
        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        if (Var.vars.containsKey(strVar)) return Var.vars.get(strVar);

        ConsoleRunner.logger.log(ConsoleRunner.res.getKeys(Messages.ERROR_VARIABLE) + strVar);
        throw new CalcException(ConsoleRunner.res.getKeys(Messages.ERROR_VARIABLE) + strVar);
    }

    static Var getVar(double x) {
        return new Scalar(x);
    }

    static Var getVar(double[] x) {
        return new Vector(x);
    }

    static Var getVar(double[][] x) {
        return new Matrix(x);
    }

}
