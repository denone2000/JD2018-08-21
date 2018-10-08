package by.it.nesterovich.jd02_06.calc;

class Creator {

    //public abstract Var factoryMethod(String string);

    static Var creator(String operand) throws CalcException {
        operand = operand.trim().replace("\\s+", "");

        if (operand.matches(Patterns.SCALAR)) {
            return new VarScalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new VarVector(operand);
        }
        if (operand.matches(Patterns.MATRIX)) {
            return new VarMatrix(operand);
        }
        if (Var.getVars().containsKey(operand)) {
            return Var.getVars(operand);
        }
        Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.UNABLE_TO_CREATE) + " " + operand, TitleType.ERROR);
        throw new CalcException(Res.INSTANCE.get(StrConst.UNABLE_TO_CREATE) + " " + operand);
    }
}
