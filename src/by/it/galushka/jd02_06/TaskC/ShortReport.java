package by.it.galushka.jd02_06.TaskC;

import by.it.galushka.jd02_06.calc.CalcException;
import by.it.galushka.jd02_06.calc.ConsoleRunner;
import by.it.galushka.jd02_06.calc.RecordBook;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class ShortReport extends ReportBuilder {

    private static Date now = new Date();
    private static DateFormat df = DateFormat.getTimeInstance();

    @Override
    public void headline() {
        report.setHeadline("Краткий отчет о работе проекта calc.");
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
        StringBuilder sb = new StringBuilder();
        List<CalcException> exceptions = RecordBook.getExceptions();
        for (int i = 0; i < exceptions.size(); i++) {
            sb.append(i).append(": ").append(exceptions.get(i).getClass().getSimpleName()).append("\n");
        }
        report.setEcxeptions("Сообщения об ошибках:\n" + sb.toString());
    }

    @Override
    public void endTime() {
        report.setEndTime(df.format(now));
    }
}
