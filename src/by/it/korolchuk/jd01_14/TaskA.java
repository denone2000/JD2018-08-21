package by.it.korolchuk.jd01_14;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) throws IOException {
        /*String root = System.getProperty("user.dir");
        System.out.println(root);
        Class<TaskA> clazz = TaskA.class;
        String path = clazz.getName();
        path = path.replace(".", File.separator);
        path = path.replace(clazz.getSimpleName(), "");
        path = root + File.separator + path;
        System.out.println(path);*/

        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/korolchuk/jd01_14/";
        String fileName = path + "dataTaskA.bin";
        String fileOutTxt = path + "resultTaskA.txt";


        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             DataOutputStream out = new DataOutputStream(fileOutputStream)) {
            for (int i = 0; i < 20; i++) {
                out.writeInt((int) (Math.random() * 100));
            }
        }
        List<Integer> list = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             DataInputStream dos = new DataInputStream(fis)) {

            while (dos.available() > 0) {
                int i = dos.readInt();
                list.add(i);
            }
        }

        try (FileWriter fr = new FileWriter(fileOutTxt);
             PrintWriter outTxt = new PrintWriter(fr)) {

            double sum = 0;
            for (Integer i : list) {
                System.out.print(i + " ");
                outTxt.print(i + " ");
                sum += i;
            }
            outTxt.println("\navg=" + sum / list.size());
            System.out.println("\navg=" + sum / list.size());
        }
       /* FileReader fileReader = new FileReader(fileOutTxt);
        BufferedReader reader = new BufferedReader(fileReader);
        while (reader.ready()) {
            String line = reader.readLine();
            System.out.println(line);
        }*/
    }
}
//





