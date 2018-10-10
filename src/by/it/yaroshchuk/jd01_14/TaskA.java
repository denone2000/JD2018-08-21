package by.it.yaroshchuk.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/yaroshchuk/jd01_14/";
        String fileName = path + "dataTaskA.bin";
        String fileOutTxt = path + "resultTaskA.txt";

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dos = new DataInputStream(fis)) {
            while(dos.available() > 0) {
                int i = dos.readInt();
                list.add(i);
            }
        }
        
        try (FileWriter fr = new FileWriter(fileOutTxt);
            PrintWriter outTxt = new PrintWriter(fr)) {
            double sum = 0;
            for (Integer i : list) {
                outTxt.print(i + " ");
                sum += i;
            }
            outTxt.println("\navg=" + sum / list.size());
        }

        FileReader fileReader = new FileReader(fileOutTxt);
        BufferedReader reader = new BufferedReader(fileReader);
        while (reader.ready()){
            String line = reader.readLine();
            System.out.println(line);
        }
    }
}
