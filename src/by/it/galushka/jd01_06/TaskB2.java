package by.it.galushka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        StringBuilder poem = new StringBuilder(Poem.text);
        Pattern delTripleDot = Pattern.compile("\\...");
        String poemWithoutTripleDot = delTripleDot.matcher(poem).replaceAll("");
        Pattern delEnter = Pattern.compile("\\n");
        String poemWithoutEnter = delEnter.matcher(poemWithoutTripleDot).replaceAll(" ");
        String[] array = poemWithoutEnter.split("\\.|\\!");
        formatPoem(array);
        sort(array);
        printPoem(array);
    }

    private static void formatPoem(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].replace(",", "").replace("-", "").replace(":", "");
            StringBuilder findDoubleSpace = new StringBuilder(array[i]);
            Pattern words = Pattern.compile("[А-яЁё]+");
            Matcher matcher = words.matcher(findDoubleSpace);
            String tmp = "";
            while (matcher.find()) {
                String group = matcher.group();
                tmp = tmp + group + " ";
            }
            array[i] = tmp.trim();
        }
    }

    private static void printPoem(String[] text) {
        for (String s : text) {
            System.out.println(s);
        }
    }

    public static void sort(String[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[j].length() < array[i].length()) {
                    String tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
