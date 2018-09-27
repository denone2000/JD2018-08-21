package by.it.litvin.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskA {

    private static String dir(Class<?>cl){
        String path= System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }
    public static void main(String[] args) {
        DataOutputStream dos=null;
        try {
            dos=new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin")));
            for (int i = 0; i <20 ; i++) {
                dos.writeInt((int)(Math.random()*20));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (dos!=null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        try(DataInputStream input=new DataInputStream(

                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")));
            PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))
        ){
            double sum=0;
            double count=0;
            while (input.available()>0){
                int i=input.readInt();
                list.add(i);
                System.out.print(i+" ");
                out2.print(i+" ");
                sum+=i;
                count++;
            }
            System.out.println("\navg="+sum/list.size());
            out2.print("\navg="+sum/list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
