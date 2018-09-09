package by.it.basumatarau.jd01_09;

public abstract class Var implements Operation {
    public static Var createVar(String strOperand) {
        if (strOperand.trim().matches(RegExPatterns.SCALAR)) return new Scalar(strOperand);
        if (strOperand.trim().matches(RegExPatterns.VECTOR)) return new Vector(strOperand);
        if (strOperand.trim().matches(RegExPatterns.MATRIX)) return new Matrix(strOperand);

        System.out.println("operand didn't fall under set of parsing patterns...");
        return null;
    }
    public abstract void accept(Dispatcher dispatcher);

    @Override
    public Var add(Var other) {
        System.out.printf("sum operation: %s + %s is not allowed\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("sub operation: %s - %s is not allowed\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("mul operation: %s * %s is not allowed\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("div operation: %s / %s is not allowed\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "Var";
    }
}
