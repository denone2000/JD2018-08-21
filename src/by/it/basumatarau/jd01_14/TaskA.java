package by.it.basumatarau.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String pathToPJDir = System.getProperty("user.dir");
        String pathToCurrentDir = pathToPJDir+"/src/"+ TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replaceAll("[.]","/");

        String fileName = pathToCurrentDir + "dataTaskA.bin";
        File f = new File(fileName);

        DataOutputStream dos = null;
        try{
            dos = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random()*10));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(dos!=null) {
                try {
                    dos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        DataInputStream dis = null;
        try{
            dis = new DataInputStream(new FileInputStream(new File(fileName)));
            while(dis.available()>0){
                list.add(dis.readInt());
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(dis!=null){
                try{
                    dis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        int sum=0;
        String txtFileName = pathToCurrentDir + "resultTaskA.txt";
        File f2 = new File(txtFileName);
        FileWriter fw = null;
        try{
            fw = new FileWriter(f2);

            for (Integer integer : list) {
                System.out.print(integer+" ");
                fw.write(integer+" ");
                sum+=integer;
            }
            System.out.println("\navg="+(double)sum/list.size());
            fw.write("\navg="+(double)sum/list.size());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fw!=null){
                try{
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }


    }
}
