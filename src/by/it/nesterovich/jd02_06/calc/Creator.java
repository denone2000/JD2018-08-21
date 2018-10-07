package by.it.nesterovich.jd02_06.calc;

class Creator {

    //public abstract Var factoryMethod(String string);

   static Var creator(String operand) throws CalcException {
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
        if (Var.getVars().containsKey(operand)) {
            return Var.getVars(operand);
        }
        Logger.getInstance().log(Res.INSTANCE.get(StrConst.UNABLE_TO_CREATE) + " " + operand);
        throw new CalcException(Res.INSTANCE.get(StrConst.UNABLE_TO_CREATE) + " " + operand);
    }
}
