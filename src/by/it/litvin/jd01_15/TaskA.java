package by.it.litvin.jd01_15;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) throws IOException {
        String root=System.getProperty("user.dir");
        String path=root+"/src/by/it/litvin/jd01_15/";
        String filename=path+"matrix.txt";
        System.out.println(filename);
        int[][] matrix=new int[6][4];
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i]=(int)(Math.random()*31-15);

            }

        }
        try (
            FileWriter writer=new FileWriter(filename);
            PrintWriter printWriter=new PrintWriter(writer);
        ){
            for (int[] row : matrix) {
                for (int value : row) {
                    printWriter.printf("%3d ", value);
                }
                    System.out.println(matrix);
                }
                printWriter.println();
            }

        try (
            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);
            ){
            List<String> rows=new ArrayList<>();
            while (reader.ready()) {
                rows.add(reader.readLine());
            }
            matrix=new int[rows.size()][0];
            int rowCounter=0;
            for (String str : rows) {
                String [] strArr=str.trim().split("\\s+");
                matrix[rowCounter]=new int[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    matrix[rowCounter][i] = Integer.parseInt(strArr[i]);
                }}
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.printf("%3d ", value);
                    }
                    System.out.println(matrix);
                }
            System.out.println();
            }
}}
