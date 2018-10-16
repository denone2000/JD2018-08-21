package by.it.yaroshchuk.calc;

public class CalcException extends Exception {

    public CalcException(){
        logException();
    }

    public CalcException(String message){
        super("ERROR: " + message);
        logException();
    }

    public CalcException(String message, Throwable cause){
        super("ERROR: " + message, cause);
        logException();
    }

    public CalcException(Throwable cause){
        super(cause);
        logException();
    }

    private void logException(){
        Logger logger = Logger.getInstance();
        logger.log(this.getMessage());
    }
}
