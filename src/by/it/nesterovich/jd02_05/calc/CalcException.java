package by.it.nesterovich.jd02_05.calc;

public class CalcException extends Exception {

    public CalcException() {
    }

    public CalcException(String message) {
        super(Res.INSTANCE.get(StrConst.TEXT_ERROR) + " " + message);
    }

    public CalcException(String message, Throwable cause) {
        super(Res.INSTANCE.get(StrConst.TEXT_ERROR) + " " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
