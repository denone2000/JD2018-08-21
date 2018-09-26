package by.it.korzik.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        String path = TaskA.class.getName();
        path = path.replaceAll("\\.", "/");
        path = dir + "/src/" + path;
        path = path.replaceAll("\\\\", "/");
        path = path.replaceAll(TaskA.class.getSimpleName(), "");
        String filePath = path + "matrix.txt";

        int[][] matrix = new int[6][4];

        matrixFiller(matrix, -15, 15);
        matrixWriter(matrix, filePath);
        matrix=readMatrix(filePath);
        printMatrix(matrix);
    }

    private static int[][] readMatrix(String filePath) {
        int[][] intArr=new int[0][0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            List<String> rows = new ArrayList<>();
           while (bufferedReader.ready()){
               rows.add(bufferedReader.readLine());
           }
           intArr=new int[rows.size()][0];
            for (int i = 0; i < rows.size(); i++) {
                String line = rows.get(i);
               String[] split = line.trim().split("\\s+");
               intArr[i]=new int[split.length];
                   for (int j = 0; j < intArr[i].length; j++) {
                       intArr[i][j]=Integer.parseInt(split[j]);
                   }
               }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return intArr;
    }

    private static void printMatrix(int[][] intArr) {
        for (int[] ints : intArr) {
            for (int anInt : ints) {
                System.out.printf("%3d ",anInt);
            }
            System.out.println();
        }
    }

    private static void matrixWriter(int[][] matrix, String filePath) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath))) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    printWriter.printf("%3d ", anInt);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void matrixFiller(int[][] matrix, int min, int max) {
        for (int[] ints : matrix) {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = (int) Math.round(Math.random() * (max - min + 1) + min);
            }
        }
    }
}
