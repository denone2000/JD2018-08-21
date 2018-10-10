package by.it.galushka.jd02_06.calc;

import by.it.galushka.jd02_06.TaskC.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    private static Res res = Res.INSTANCE;

    public static Date now = new Date();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        Res res = Res.INSTANCE;
        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            Locale locale = new Locale(language, country);
            res.setLocale(locale);
        }
        System.out.println(res.get(Messages.MSG_ERROR_ENTER));
        while (!(line = scanner.nextLine()).equals(res.get(Messages.MSG_ERROR_END))) {
            boolean local = chooseLocal(line);
            if (local) {
                if (line.equals("printvar")) {
                    System.out.println(Var.printVar());
                } else {
                    try {
                        Var result = parser.calc(line.trim());
                        printer.print(result);
                        RecordBook.setEnteredExpressions("Введенное выражение: " + line + "\n"
                                + "Результат: " + result.toString() + "\n");
                    } catch (CalcException e) {
                        RecordBook.setExceptions(e);
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                System.out.println(res.get(Messages.MSG_ERROR_ENTER));
                System.out.println(res.get(Messages.MSG_ERROR_EXIT));
            }
        }
        //you can choose Full or Short report
        createShortReport();
        //createFullReport();
    }

    private static void createFullReport() {
        Writter writter = new Writter();
        ReportBuilder rb = new FullReport();
        writter.setReportBuilder(rb);
        writter.constructReport();
        System.out.println(writter.getReport());
        createReportFile(writter.getReport());
    }

    private static void createShortReport() {
        Writter writter = new Writter();
        ReportBuilder rb = new ShortReport();
        writter.setReportBuilder(rb);
        writter.constructReport();
        System.out.println(writter.getReport());
        createReportFile(writter.getReport());
    }

    private static void createReportFile(Report report) {
        String directory = getDirectory(ConsoleRunner.class);
        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(directory.concat("report.txt")))
        ) {
            writer.println(report);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static boolean chooseLocal(String loc) {
        boolean local = true;
        Locale locale = null;
        if (loc.equalsIgnoreCase("en")) {
            locale = new Locale("en", "EN");
            res.setLocale(locale);
            local = false;
        } else if (loc.equalsIgnoreCase("ru")) {
            locale = new Locale("ru", "RU");
            res.setLocale(locale);
            local = false;
        } else if (loc.equalsIgnoreCase("be")) {
            locale = new Locale("be", "BY");
            res.setLocale(locale);
            local = false;
        }
        return local;
    }

    private static String getDirectory(Class<?> clss) {
        StringBuilder path = new StringBuilder();
        String dir = clss.getName().replace(".", File.separator).replace(clss.getSimpleName(), "");
        path.append(System.getProperty("user.dir")).append(File.separator);
        path.append("src").append(File.separator).append(dir);
        return path.toString();
    }
}
