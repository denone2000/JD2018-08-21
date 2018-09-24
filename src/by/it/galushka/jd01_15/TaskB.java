package by.it.galushka.jd01_15;

import java.io.*;

public class TaskB {

    /**
     * @author Галушка Игорь
     * @versoin 1.0
     */
    public static void main(String[] args) {
        /*прописываем путь для прочтения нужного файла
        используем для этого метод getDirectory()*/
        String pathToFile = getDirectory(TaskB.class) + "TaskB.java";
        /*создаем переменную типа StringBuilder для записи кода класса TaskB
        для получения кода класса TaskB используем метод readJavaFile()*/
        StringBuilder textTaskB = readJavaFile(pathToFile);
        /*записываем результат в файл и выводим на консоль
        используем метод writeResultInFileTxtAndConsole()*/
        writeResultInFileTxtAndConsole(textTaskB, getDirectory(TaskB.class));
    }

    /**
     * @param sb  код класса TaskB в формате StringBuilder
     * @param dir путь для создания фала TaskB.txt
     *            данный метод выводит код класса TaskB на консоль и записывает его в созданный
     *            файл TaskB.txt.
     */
    private static void writeResultInFileTxtAndConsole(StringBuilder sb, String dir) {
        //create Writer
        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(dir + "TaskB.txt"))
        ) {
            writer.print(sb);
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param pathToFile путь к файлу TaskB.java
     * @return данный метод возвращает код класса TaskB в формате StringBuilder
     */
    private static StringBuilder readJavaFile(String pathToFile) {
        //create StringBuilder
        StringBuilder sb = new StringBuilder();
        StringBuilder removedComments = new StringBuilder();
        //create Reader
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(pathToFile))
        ) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.contains(SymbolsForTaskB.javaDoc)) {
                    int startCommentIndex = line.indexOf("/");
                    String tmp = line.substring(startCommentIndex);
                    String result = line.replace(tmp, "");
                    sb.append(result).append("\n");
                } else if (line.contains(SymbolsForTaskB.comment)) {
                    int startCommentIndex = line.indexOf("/");
                    String tmp = line.substring(startCommentIndex);
                    String result = line.replace(tmp, "");
                    sb.append(result).append("\n");
                } else if (line.contains(SymbolsForTaskB.javaDocEnd)) {
                    removedComments.append(line).append("\n");
                } else if (line.contains(SymbolsForTaskB.javaDocMidle)) {
                    removedComments.append(line).append("\n");
                } else {
                    sb.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    private static String getDirectory(Class<?> clss) {
        StringBuilder path = new StringBuilder();
        String dir = clss.getName().replace(".", File.separator).replace(clss.getSimpleName(), "");
        path.append(System.getProperty("user.dir")).append(File.separator);
        path.append("src" + File.separator).append(dir);
        return path.toString();
    }
}