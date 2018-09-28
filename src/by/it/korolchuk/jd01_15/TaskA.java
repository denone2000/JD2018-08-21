package by.it.korolchuk.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    /**@param args**/
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/korolchuk/jd01_15/";
        String fileName = path + "matrix.txt";
        int[][] matrix = new int[6][4];
//это однострочный комментарий
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = (int) (Math.random() * 31 - 15);
            }
        }
        //и это однострочный комментарий
        try (FileWriter filewriter = new FileWriter(fileName);
             PrintWriter print = new PrintWriter(filewriter)) {
            for (int[] row : matrix) {
                for (int value : row) {
                    print.printf("%3d ", value);
                    System.out.printf("%3d ", value);
                }
                System.out.println();
                print.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
/*а это -
dfghjkl
двустрочный комментарий*/
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {

            List<String> rows = new ArrayList<>();
/*и это -
двустрочный*/
            while (reader.ready()) {
                rows.add(reader.readLine());
            }
            matrix = new int[rows.size()][0];
            int rowCounter = 0;
            for (String str : rows) {
                String[] strArr = str.split("\\s+");
                matrix[rowCounter] = new int[strArr.length];
            }
        }
    }
}



