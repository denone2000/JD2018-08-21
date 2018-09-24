package by.it.galushka.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {

        //создаем и заполяем матрицу
        int[][] matrix = getMatrix(6, 4);

        //создаем файл matrix.txt и записываем матрицу
        createFileTxtAndWriteData(matrix);

        //читаем файл и выводим на консоль
        readAndPrintFile();
    }

    private static void readAndPrintFile() {
        String pathToFile = getDirectory(TaskA.class) + "matrix.txt";
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(pathToFile))
        ) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] numbers = line.trim().split("\\s+");
                printRowsMatrix(numbers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printRowsMatrix(String[] numbers) {
        for (String number : numbers) {
            String trim = number.trim();
            int num = Integer.parseInt(trim);
            System.out.printf("%3d ", num);
        }
        System.out.println();
    }

    private static void createFileTxtAndWriteData(int[][] matrix) {
        String dir = getDirectory(TaskA.class);
        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(dir + "matrix.txt"))
        ) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int num = matrix[i][j];
                    writer.printf("%3d ", num);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] getMatrix(int rowCount, int colomnCount) {
        int[][] matrix = new int[rowCount][colomnCount];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 32 - 16);
            }
        }
        return matrix;
    }

    private static String getDirectory(Class<?> clss) {
        StringBuilder path = new StringBuilder();
        String dir = clss.getName().replace(".", File.separator).replace(clss.getSimpleName(), "");
        path.append(System.getProperty("user.dir")).append(File.separator);
        path.append("src" + File.separator).append(dir);
        return path.toString();
    }
}
