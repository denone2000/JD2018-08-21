package by.it.bindyuk.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + "/src/by/it/bindyuk/jd01_15/";
        String fileName = path + "matrix.txt";

        int[][] matrix = new int[6][4];
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                row[j] = (int) (Math.random() * 31) - 15;
            }
        }

        List<String> list = new ArrayList<>();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        ) {
            for (int[] row : matrix) {
                for (int value : row) {
                    writer.printf("%3d ", value);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while (reader.ready()) {
                list.add(reader.readLine());
            }

            int[][] matrixConsole = new int[list.size()][0];
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                String[] strMas = str.trim().split("\\s+");
                matrixConsole[i] = new int[strMas.length];
                for (int j = 0; j < strMas.length; j++) {
                    matrixConsole[i][j] = Integer.parseInt(strMas[j]);
                }
            }

            for (int[] rows : matrixConsole) {
                for (int value : rows) {
                    System.out.printf("%3d ", value);
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

