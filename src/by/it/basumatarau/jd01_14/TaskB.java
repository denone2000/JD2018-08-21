package by.it.basumatarau.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String projectRootPath = System.getProperty("user.dir");

        System.out.println(projectRootPath);
        String path = projectRootPath +"/src/"+
                TaskB.class.getName().replaceAll(TaskB.class.getSimpleName(),"").replaceAll("[.]",
                        System.getProperty("file.separator"));
        System.out.println(path);

        File f = new File(path+"text.txt");
        FileReader inputStream = null;
        BufferedReader buffReader = null;
        String line;
        Pattern word = Pattern.compile("[а-яА-яЁё]+");
        Pattern mark = Pattern.compile("[^а-яА-яЁё\\s]+");
        int wordCounter =0;
        int punctMarksCounter =0;
        try{
            inputStream = new FileReader(f);
            buffReader = new BufferedReader(inputStream);

            while(buffReader.ready()) {
                line = buffReader.readLine();
                Matcher wordMatcher = word.matcher(line);
                Matcher markMatcher = mark.matcher(line);
                while (wordMatcher.find()){
                    wordCounter++;
                }
                while(markMatcher.find()){
                    punctMarksCounter++;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(inputStream!=null){
                try {
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(buffReader!=null){
                try{
                    buffReader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        File result = new File(path+"resultTaskB.txt");
       BufferedWriter buffresultFW = null;
        try{
            buffresultFW = new BufferedWriter(new FileWriter(result));
            buffresultFW.write(String.format("\nwords=%s, punctuation marks=%s", wordCounter, punctMarksCounter));
            System.out.printf("\nwords=%s, punctuation marks=%s", wordCounter, punctMarksCounter);

        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(buffresultFW!=null){
                try{
                    buffresultFW.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
