package by.it.litvin.jd01_15;

import by.it.galushka.jd01_03.Print;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskA {
    public static void main(String[] args) {
        String root=System.getProperty("user.dir");
        String path=root+"/src/by/it/_tasks_/jd01_15/";
        String filename=path+"matrix.txt";
        System.out.println(filename);
        int[][] matrix=new int[6][4];
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i]=(int)(Math.random()*31-15);

            }

        }
        try {
            FileWriter writer=new FileWriter(filename);
            PrintWriter printWriter=new PrintWriter(writer);
            for (int[] row : matrix) {
                for (int value : row) {
                    printWriter.printf("%3d ",value);
                }
                printWriter.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
