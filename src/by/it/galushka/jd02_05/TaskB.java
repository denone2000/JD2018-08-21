package by.it.galushka.jd02_05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    private static StringBuilder usedCommands = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Res res = Res.INSTANCE;
        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            Locale locale = new Locale(language, country);
            res.setLocale(locale);
        }
        System.out.println(res.get(Messages.MSG_ENTER));
        usedCommands.append(res.get(Messages.MSG_ENTER)).append("\n");
        String inputLocal;
        while (!(inputLocal = scanner.nextLine()).equalsIgnoreCase(res.get(Messages.INPUT_END))) {
            usedCommands.append(inputLocal).append("\n");
            chooseLocal(res, inputLocal);
        }
        usedCommands.append(inputLocal);
        writeUsedCommands();
    }

    private static void writeUsedCommands() {
        String pathForCreateFile = getDirectory(TaskB.class);
        try (BufferedWriter writer =
                     new BufferedWriter(
                            new FileWriter(pathForCreateFile + "команды.txt"))
        ){
            writer.write(usedCommands.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void chooseLocal(Res res, String loc) {
        Dat date = Dat.INSTANCE;
        Locale locale;
        if (loc.equalsIgnoreCase("en")) {
            locale = new Locale("en", "EN");
            res.setLocale(locale);
            doIt(res, date, locale);
        } else if (loc.equalsIgnoreCase("ru")) {
            locale = new Locale("ru", "RU");
            res.setLocale(locale);
            doIt(res, date, locale);
        } else if (loc.equalsIgnoreCase("be")) {
            locale = new Locale("be", "BY");
            res.setLocale(locale);
            doIt(res, date, locale);
        } else {
            System.out.println(res.get(Messages.MSG_WARNING));
            usedCommands.append(res.get(Messages.MSG_WARNING + "\n"));
        }
    }

    private static void doIt(Res res, Dat date, Locale locale) {
        date.setDate("full", locale);
        printMessagesAndDate(res, date);
    }

    private static void printMessagesAndDate(Res res, Dat date) {
        System.out.println(res.get(Messages.MSG_HELLO));
        usedCommands.append(res.get(Messages.MSG_HELLO)).append("\n");
        System.out.println(res.get(Messages.MSG_MEET));
        usedCommands.append(res.get(Messages.MSG_MEET)).append("\n");
        System.out.println(res.get(Messages.MSG_NAME));
        usedCommands.append(res.get(Messages.MSG_NAME)).append("\n");
        System.out.println(res.get(Messages.MSG_TODAY) + " " + date.getActualDate());
        usedCommands.append(res.get(Messages.MSG_TODAY)).append(" ").append(date.getActualDate()).append("\n");
        System.out.println();
        usedCommands.append("\n");
        System.out.println(res.get(Messages.MSG_ENTER));
        usedCommands.append(res.get(Messages.MSG_ENTER)).append("\n");
        System.out.println(res.get(Messages.MSG_EXIT));
        usedCommands.append(res.get(Messages.MSG_EXIT)).append("\n");
        System.out.println();
        usedCommands.append("\n");
    }

    private static String getDirectory(Class<?> clss) {
        StringBuilder path = new StringBuilder();
        String dir = clss.getName().replace(".", File.separator).replace(clss.getSimpleName(), "");
        path.append(System.getProperty("user.dir")).append(File.separator);
        path.append("src").append(File.separator).append(dir);
        return path.toString();
    }
}
