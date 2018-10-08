package by.it.galushka.jd02_06.calc;

public class CalcException extends Exception {

    private static Res res = Res.INSTANCE;

    public CalcException() {
    }

    public CalcException(String message) {
        super(res.get(Messages.MSG_ERROR) + ": " + message);
    }

    public CalcException(String message, Throwable cause) {
        super(res.get(Messages.MSG_ERROR) + ": " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
    }
}
