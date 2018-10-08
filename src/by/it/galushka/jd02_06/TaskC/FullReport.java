package by.it.galushka.jd02_06.TaskC;

import by.it.galushka.jd02_06.calc.CalcException;
import by.it.galushka.jd02_06.calc.ConsoleRunner;
import by.it.galushka.jd02_06.calc.RecordBook;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class FullReport extends ReportBuilder {

    private static Date now = new Date();
    private static DateFormat df = DateFormat.getDateTimeInstance();

    @Override
    public void headline() {
        report.setHeadline("Подробный отчет о работе проекта calc.");
    }

    @Override
    public void startTime() {
        report.setStartTime(df.format(ConsoleRunner.now));
    }

    @Override
    public void enteredExpression() {
        report.setEnteredExpression("\nВведенные операции и их результаты:\n"
                + RecordBook.getEnteredExpressions());
    }

    @Override
    public void exceptions() {
        List<CalcException> exceptions = RecordBook.getExceptions();
        report.setEcxeptions("Сообщения об ошибках:\n"
                + convertExceptions(exceptions));
    }

    @Override
    public void endTime() {
        report.setEndTime(df.format(now));
    }

    private static String convertExceptions(List<CalcException> exceptions) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exceptions.size(); i++) {
            StackTraceElement[] stackTrace = exceptions.get(i).getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(i).append(": ").append(stackTraceElement).append("\n");
            }
        }
        return sb.toString();
    }
}
