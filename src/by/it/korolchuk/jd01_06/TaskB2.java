package by.it.korolchuk.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {

        sortArray(PoemCopy.text);
    }

    private static void sortArray(String text) {
        String[] split = text.split("[;.!?]");

        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replaceAll("[-:,\n]", " ").trim();
            split[i] = split[i].replaceAll("   ", " ");
            split[i] = split[i].replaceAll("  ", " ");
        }


        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < split.length - 1 - i; j++) {
                if (split[j].length() > split[j + 1].length()) {
                    String str = split[j];
                    split[j] = split[j + 1];
                    split[j + 1] = str;
                }
            }
        }

        for (String s : split) {
            System.out.println(s);
        }
    }
}


