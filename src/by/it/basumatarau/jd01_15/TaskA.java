package by.it.basumatarau.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=(int)(Math.random()*31-15);
            }
        }
        File f = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+
                TaskA.class.getName().replace(".", File.separator).replaceAll(TaskA.class.getSimpleName(),"")
                +File.separator+"matrix.txt");

        try(BufferedWriter buffR = new BufferedWriter(new FileWriter(f))){
            for (int[] aMatrix : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    buffR.write(String.format("%3d ", aMatrix[j]));
                }
                buffR.write('\n');
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try(BufferedReader buffR = new BufferedReader(new FileReader(f))){
            List<String> rows = new ArrayList<>();
            while(buffR.ready()){
                rows.add(buffR.readLine());
            }
            matrix = new int[rows.size()][];
            int rowCounter = 0;
            for (String row : rows) {
                int[] intRow = new int[row.trim().split("\\s+").length];
                int colCounter =0;
                for (String intStr : row.trim().split("\\s+")) {
                    intRow[colCounter++]=Integer.parseInt(intStr);
                }
                matrix[rowCounter++]=intRow;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(String.format("%3d ", aMatrix[j]));
            }
            System.out.print('\n');
        }
    }
}
