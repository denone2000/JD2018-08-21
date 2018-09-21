package by.it.galushka.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    /*
    Вариант B. В классе TaskBнужно выполнить следующие шаги:
    В файле с текстом TaskB.txt нужно подсчитать общее количество знаков препинания и слов
    Вывести результат на консоль в виде одной строки:words=123, punctuation marks=15
    Продублировать вывод в консоль в файл resultTaskB.txt
     */

    private static int wordsCounter = 0;
    private static int punctCounter = 0;

    public static void main(String[] args) {
        // получеам путь к файлам
        String dir = TaskA.getDirectory(TaskB.class);
        // создаем файл TaskB.txt и копируем данные из text.txt
        createAndCopy(dir);
        // считаем количсетво слов и знаков препинания
        wordsAndPunctCounter(dir);
        // выводим результат на консоль и в файл resultTaskB.txt
        writeResult(dir);
    }

    private static void writeResult(String dir) {
        String nameCreateFile = "resultTaskB.txt";
        StringBuilder writeFile = new StringBuilder(dir);
        writeFile.append(nameCreateFile).toString();
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(writeFile.toString()))
        ) {
            printWriter.print("words=" + wordsCounter);
            System.out.println("words=" + wordsCounter);
            printWriter.println("\npunctuation marks=" + punctCounter);
            System.out.println("punctuation marks=" + punctCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createAndCopy(String dir) {
        try (PrintWriter pw =
                     new PrintWriter(
                             new FileWriter(dir + "TaskB.txt"));
             BufferedReader br =
                     new BufferedReader(
                             new FileReader(dir + "text.txt"))
        ) {
            while (br.ready()) {
                String line = br.readLine();
                pw.print(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void wordsAndPunctCounter(String dir) {
        StringBuilder readFile = new StringBuilder(dir);
        readFile.append("TaskB.txt");
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(readFile.toString()))
        ) {
            while (reader.ready()) {
                String line = reader.readLine();
                wordsCounter = wordsCounter + wordsCounter(line);
                punctCounter = punctCounter + punctCounter(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int punctCounter(String line) {
        int result = 0;
        List<String> punctList = new ArrayList<>();
        String lineEdit = line.replace("...", ".");
        StringBuilder sb = new StringBuilder(lineEdit);
        Pattern compile = Pattern.compile("\\p{Punct}");
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()) {
            String group = matcher.group();
            punctList.add(group);
        }
        result = punctList.size();
        return result;
    }

    private static int wordsCounter(String line) {
        int result = 0;
        String[] words = line.split("[^А-яЁё]+");
        result = words.length;
        return result;
    }
}
