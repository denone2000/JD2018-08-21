package by.it.galushka.jd02_06.calc;

import java.util.ArrayList;
import java.util.List;

public class RecordBook {

    private static StringBuilder enteredExpressions = new StringBuilder();

    private static List<CalcException> exceptions = new ArrayList<>();

    public static String getEnteredExpressions() {
        return enteredExpressions.toString();
    }

    static void setEnteredExpressions(String expression) {
        enteredExpressions.append(expression);
    }

    public static List<CalcException> getExceptions() {
        return exceptions;
    }

    public static void setExceptions(CalcException exception) {
        exceptions.add(exception);
    }
}
