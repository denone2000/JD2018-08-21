package by.it.kisielev.jd01_14;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) throws IOException {
        /*String root = System.getProperty("user.dir");
        System.out.println(root);
        Class<TaskA> clazz = TaskA.class;
        String path = clazz.getName();
        path = path.replace(".", File.separator);
        path = path.replace(clazz.getSimpleName(), File.separator);
        path = root + File.separator;
        System.out.println(path);*/

        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/kisielev/jd01_14/";
        String fileName = path + "dataTaskA.bin";
        String fileOutText = path + "resultTaskA.txt";
        //write int
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             DataOutputStream out = new DataOutputStream(fileOutputStream)) {
            for (int i = 0; i < 20; i++) {
                out.writeInt((int) (Math.random() * 100));
            }
        }

        //read int
        List<Integer> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             DataInputStream dos = new DataInputStream(fis)) {
            while (dos.available() > 0) {
                int i = dos.readInt();
                list.add(i);
            }
        }
        try (FileWriter fr= new FileWriter(fileOutText);
             PrintWriter outTxt= new PrintWriter(fr))
             {
                 //print int
                 double sum = 0;
                 for(Integer i : list){
                  outTxt.print(i + " ");
                  sum += i;
                 }
                 //print avg
                 outTxt.print("\navg=" + sum / list.size());
             }

             //read txt
        FileReader fileReader=new FileReader(fileOutText);
        BufferedReader reader= new BufferedReader(fileReader);
        while(reader.ready()){
            String line=reader.readLine();
            System.out.println(line);
        }
    }

}