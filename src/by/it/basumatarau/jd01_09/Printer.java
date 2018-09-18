package by.it.basumatarau.jd01_09;

public class Printer {
    public String print(Var var) {
        if (var!=null) return var.toString();
        return "null pointer has been passed to " + getClass().getSimpleName();
    }
}
