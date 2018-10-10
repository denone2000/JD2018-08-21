package by.it.nesterovich.jd02_06.calc;

public class CalcException extends Exception {

    public CalcException() {
    }

    public CalcException(String message) {
        super(Res.INSTANCE.get(StrConst.TEXT_ERROR) + " " + message);
        //Logger.getInstance().log(Res.INSTANCE.get(StrConst.TEXT_ERROR) + " " + message);
    }

    public CalcException(String message, Throwable cause) {
        super(Res.INSTANCE.get(StrConst.TEXT_ERROR) + " " + message, cause);
        //Logger.getInstance().log();
    }

    public CalcException(Throwable cause) {
        super(cause);
        //Logger.getInstance().log();
    }
}
