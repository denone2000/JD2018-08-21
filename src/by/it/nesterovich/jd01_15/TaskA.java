package by.it.nesterovich.jd01_15;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {
        Integer[][] matrix = new Integer[6][4];

        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(dir(TaskA.class) + "matrix.txt"))
        ) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = (int) (Math.random() * 31) - 15;
                    printWriter.printf("%4d",matrix[i][j]);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(dir(TaskA.class) + "matrix.txt"))
        ) {
            StringBuilder text = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                text.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            System.out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
}
