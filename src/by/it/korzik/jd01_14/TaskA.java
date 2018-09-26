package by.it.korzik.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/korzik/jd01_14";
        String fileName = path + "/dataTaskA.bin";
        String fileOut = path + "/resultTaskA.txt";
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(((int) (Math.random() * 100 + 1)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> list = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(new FileInputStream(fileName))) {
        while (in.available()>0){
            list.add(in.readInt());
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        double sum=0;
        for (Integer integer : list) {
            System.out.print(integer+" ");
            sum+=integer;
        }
        System.out.println("\n"+"avg="+sum/list.size());
        sum=0;
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileOut))){
            for (Integer integer : list) {
                printWriter.print(integer+" ");
                sum=sum+integer;
            }
            printWriter.println("\n"+"avg="+(sum/list.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
