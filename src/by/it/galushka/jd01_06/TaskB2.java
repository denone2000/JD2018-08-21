package by.it.galushka.jd01_06;

/*TaskB2.Вывести через \nвсе предложения текста в порядке возрастания количества
символов (!) в каждом из них. В предложениях нужно сначала заменить все небуквенные
символы и их последовательности на один пробели выполнить trim() для каждого предложения.*/

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] text = {};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[А-яЁё]+.[^\\.]+");
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()) {
            String group = matcher.group();
            getArray(group);
        }
        getString(text);
        sort(text);
        printGroup(text);
    }

    private static void getArray(String group) {
        text = Arrays.copyOf(text, text.length+1);
        text[text.length-1] = group;
    }

    private static void printGroup(String[] text) {
        for (String s : text) {
            System.out.println(s);
        }
    }

    private static void getString(String[] text) {
        for (int i = 0; i < text.length; i++) {
            String tmp = text[i];
            text[i] = splitAndConcat(tmp);
        }
    }

    public static String splitAndConcat(String tmp) {
        String[] array = tmp.split("\\p{Punct}?\\s\\p{Punct}?\\s?");
        String result = "";
        for (int i = 0; i < array.length; i++) {
            String trim = array[i].trim();
            result = result.concat(trim + " ");
        }
        String trim = result.trim();
        return trim;
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
