package by.it.akhmelev.jd01_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/akhmelev/jd01_15/";
        String filename = path + "matrix.txt";
        System.out.println(filename);

        int[][] matrix = generate();
        //write file
        writeFile(filename, matrix);

        //read file
        matrix = readListLine(filename);
        //print matrix
        printMatrix(matrix);


    }

    private static int[][] generate() {
        int[][] matrix = new int[6][4];
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = (int) (Math.random() * 31 - 15);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%3d ", value);
            }
            System.out.println();
        }
    }

    private static int[][] readListLine(String filename) throws IOException {
        int[][] matrix;
        try (
                FileReader fileReader = new FileReader(filename);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            List<String> rows = new ArrayList<>();

            while (reader.ready()) {
                rows.add(reader.readLine());
            }

            matrix = new int[rows.size()][0];
            for (int i = 0; i < rows.size(); i++) {
                String str = rows.get(i);
                String[] strArr = str.trim().split("\\s+");
                matrix[i] = new int[strArr.length];
                for (int j = 0; j < strArr.length; j++) {
                    matrix[i][j] = Integer.parseInt(strArr[j]);
                }
            }
        }
        return matrix;
    }

    private static void writeFile(String filename, int[][] matrix) throws IOException {
        try (FileWriter writer = new FileWriter(filename);
             PrintWriter printWriter = new PrintWriter(writer)) {
            for (int[] row : matrix) {
                for (int value : row) {
                    printWriter.printf("%3d ", value);
                }
                printWriter.println();
            }
        }
    }
}
