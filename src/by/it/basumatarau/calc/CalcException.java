package by.it.basumatarau.calc;

public class CalcException extends Exception {

    public CalcException() {
    }

    public CalcException(String s) {
        super("ERROR: "+s);
    }

    public CalcException(String s, Throwable throwable) {
        super("ERROR: "+s, throwable);
    }

    public CalcException(Throwable throwable) {
        super(throwable);
    }
}
