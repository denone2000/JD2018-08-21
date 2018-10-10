package by.it.basumatarau.calc.v3;

public class Printer {
    public String print(Var var) throws CalcException{
        if (var!=null) return var.toString();
        throw new CalcException(CalcExceptionResManager.ENTITY.getMsgByKey(I18nKeys.PRINTER_EXCEPTION_NULL_POINTER_INPUT)
                + getClass().getName());
    }
}
