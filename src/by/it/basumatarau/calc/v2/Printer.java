package by.it.basumatarau.calc.v2;

public class Printer {
    public String print(Var var) throws CalcException {
        if (var!=null) return var.toString();
        throw new CalcException("null pointer has been passed to " + getClass().getName());
    }
}
