package by.it.artemliashkov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String args[])
    {
        String path=System.getProperty("user.dir");
        path=path+"/src/by/it/artemliashkov/jd01_14/";
        String fileName=path+"dataTaskA.bin";
        String fileOuttxt=path+"resultTaskA.txt";
        try(FileOutputStream fileOutputStream=new FileOutputStream(fileName);
            DataOutputStream out=new DataOutputStream(fileOutputStream);){
            for (int i = 0; i <20 ; i++) {
                out.writeInt((int) (Math.random() * 100));
            }
            //out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> list=new ArrayList();
        try(DataInputStream dos=new DataInputStream(new FileInputStream(fileName))) {
           while(dos.available()>0)
           {
               int i=dos.readInt();
               list.add(i);
           }
        }catch (IOException e) {
            e.printStackTrace();
        }
        double sum=0.0;
        for (Integer i : list) {
            System.out.println(i+" ");
            sum=sum+i;
        }
        System.out.println("\navg="+sum/list.size());
        try (FileWriter fr=new FileWriter(fileOuttxt);
             PrintWriter outtxt=new PrintWriter(fr);){
            sum=0.0;
            for (Integer i : list) {
                System.out.print(i+" ");
                outtxt.print(i+" ");
                sum=sum+i;
            }
            System.out.println("\navg="+sum/list.size());
            outtxt.println("\navg="+sum/list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
