package by.it.artemliashkov.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String args[])
    {
        String path=System.getProperty("user.dir");
        path=path+"/src/by/it/artemliashkov/jd01_15/";
        String fileOuttxt=path+"matrix.txt";
        Integer[][] matrix = new Integer[6][4];
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(fileOuttxt))
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
                new FileReader(fileOuttxt))
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
}
