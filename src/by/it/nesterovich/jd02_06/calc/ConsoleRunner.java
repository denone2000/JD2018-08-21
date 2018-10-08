package by.it.nesterovich.jd02_06.calc;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        Logger logger = Logger.getInstance();
        logger.writeReport("Приложение начало работу", TitleType.INFO);
        System.out.println("To choose English, enter: en");
        System.out.println("Для выбора русского языка введите: ru");
        System.out.println("Для выбару беларускай мовы увядзіце: be");
        //System.out.println(Res.INSTANCE.get(StrConst.FINISH_PROGRAM) + " " + Res.INSTANCE.get(StrConst.WORD_FINISH));
        while (!(line = scanner.nextLine()).equalsIgnoreCase(Res.INSTANCE.get(StrConst.WORD_FINISH))) {
            try {
                logger.writeReport(line, TitleType.INPUT);
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        logger.writeReport("Приложение завершило работу", TitleType.INFO);

    }
}
