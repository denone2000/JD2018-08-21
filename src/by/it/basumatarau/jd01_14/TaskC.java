package by.it.basumatarau.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

public class TaskC {
    public static void main(String[] args) {
        String rootPath = System.getProperty("user.dir")+"/src/";
        String innerPath = TaskC.class.getName().replaceAll("[.]", System.getProperty("file.separator")).replaceAll(("[^/]+/"+TaskC.class.getSimpleName()),"");
        System.out.println(rootPath+innerPath);
        File entrance = new File(rootPath+innerPath);
        File result = new File(rootPath+TaskC.class.getName().replaceAll("[.]", System.getProperty("file.separator")).replaceAll((TaskC.class.getSimpleName()),"")+"resultTaskC.txt");

        try(BufferedWriter buffFW = new BufferedWriter(
                new FileWriter(result))) {
            fileTreePrinter(entrance, buffFW, 0);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void fileTreePrinter(File entrance, BufferedWriter buffFW, int offset) throws IOException{
        if(!entrance.isDirectory()){
            return;
        }

        offset++;
        for (String fileName : new TreeSet<>(Arrays.asList(entrance.list()))) {
            File file = new File(entrance.getAbsolutePath()+System.getProperty("file.separator")+fileName);
            if (file.isDirectory()){
                for (int i = 1; i < offset; i++) {
                    System.out.print('\t');
                    buffFW.append('\t');
                }
                System.out.print("dir:"+fileName+"\n");
                buffFW.write("dir:"+fileName+"\n");

                fileTreePrinter(file, buffFW, offset);
            }else {
                for (int i = 1; i < offset; i++) {
                    System.out.print('\t');
                    buffFW.append('\t');
                }
                System.out.print("file:"+fileName+"\n");
                buffFW.write("file:"+fileName+"\n");
            }
        }
    }
}
