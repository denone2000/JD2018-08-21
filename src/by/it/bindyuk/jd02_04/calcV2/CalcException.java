package by.it.bindyuk.jd02_04.calcV2;

public class CalcException extends Exception {

    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(ConsoleRunner.res.getKeys(Messages.ERROR_ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ConsoleRunner.res.getKeys(Messages.ERROR_ERROR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
