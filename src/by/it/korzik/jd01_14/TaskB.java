package by.it.korzik.jd01_14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/korzik/jd01_14";
        String fileName = path + "/TaskB.txt";
        Pattern wordPattern = Pattern.compile("А-Яа-яёЁ");
        try (  BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
                Matcher matchWord = wordPattern.matcher(fileName);
                while (matchWord.find()){
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
