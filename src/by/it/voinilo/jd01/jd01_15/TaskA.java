package by.it.voinilo.jd01.jd01_15;

import java.io.*;
import java.util.ArrayList;

public class TaskA {

    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }

    public static void main(String[] args) {
        int[][] matrix;
        matrix = new int[6][4];
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(dir(TaskA.class) + "matrix.txt"))
        ) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = (int) (Math.round(Math.random() * 30 - 15));
                    printWriter.printf("%3d ", matrix[i][j]);


                }
                printWriter.printf("%n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader (dir(TaskA.class) + "matrix.txt")) ){
            for (int i = 0; i < 6; i++) {
                System.out.println(bufferedReader.readLine());
            }

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
