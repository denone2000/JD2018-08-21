package by.it.korolchuk.jd01_06;

import java.util.Arrays;

public class TaskC1 {
    public static void main(String[] args) {
        stringToArr(Poem.text);
        arrEltToWords(stringToArr(Poem.text));

    }
    
    private static String[] stringToArr (String text) {
        String[] lines = text.split("\n");
        return lines;
    }


    private static void arrEltToWords(String[] lines) {
        Arrays.sort(lines);
        final int max = lines[lines.length-1].length();

        for (int i = 0; i < lines.length; i++) {
            char[] tmp = lines[i].toCharArray();
            if (max > tmp.length) {
                /*while (max > tmp.length) {

                    lines[i] = lines[i].replaceAll("[\\s]", "  ");
                    System.out.println(lines[i]);

                }*/

            }
            System.out.println(lines[i]);
        }
        
    }
}
