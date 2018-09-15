package by.it.basumatarau.calc;

public class Printer {
    public String print(Var var) {
        if (var!=null) return var.toString();
        return "null pointer has been passed to " + getClass().getSimpleName();
    }
}
