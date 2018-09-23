package by.it.korzik.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        int row=0;
        String dir = System.getProperty("user.dir");
        String path = TaskA.class.getName();
        path = path.replaceAll("\\.", "/");
        path = dir + "/src/" + path;
        path = path.replaceAll("\\\\", "/");
        path = path.replaceAll(TaskA.class.getSimpleName(), "");
        matrixFiller(matrix, -15, 15);
        String filePath = path + "matrix.txt";
        matrixWriter(matrix, filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
           while (bufferedReader.ready()){
               bufferedReader.readLine();
               row++;
           }
           int[][] intArr=new int[row][];
           while (bufferedReader.ready()){
               String[] split = bufferedReader.readLine().trim().split("\\s+");
               for (int j = 0; j < intArr.length; j++) {

                   intArr[j] = new int[split.length];
                   for (int i = 0; i < intArr[j].length; i++) {
                       intArr[j][i]=Integer.parseInt(split[i]);
                   }
               }
           }
            for (int[] ints : intArr) {
                for (int anInt : ints) {
                    System.out.print(anInt);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
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
                System.out.print(ints[i]);
            }
            System.out.println();
        }
    }
}
