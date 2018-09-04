package by.it.galushka.jd01_06;

import java.util.regex.Pattern;

public class TaskC1 {
    /*TaskC1. Отформатировать исходный текст с выравниванием по обоим краям. Для этого
    добавить дополнительные пробелы между словами, так чтобы ширина строк стала равной, а
    число пробелов между словами отличалось не более чем на единицу внутри каждой строки,
    причем на единицу большие последовательности пробелов должны идти с начала строки.*/

    public static String[] array = {};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("\\n");
        array = compile.split(sb);
        int maxLength = findMaxLength(array);
        align(array, maxLength);
        printArray(array);
    }

    private static void printArray(String[] array) {
        String text = "";
        for (int i = 0; i < array.length; i++) {
            text = text + array[i] + "\n";
        }
        System.out.println(text);
    }

    private static int findMaxLength(String[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > max) {
                max = array[i].length();
            }
        }
        return max;
    }

    private static void align(String[] array, int maxLength) {
        for (int i = 0; i < array.length; i++) {
            String[] tmp = array[i].split("\\p{Punct}?\\s");
            StringBuilder sb;
            String str = " ";
            if (array[i].length() < maxLength) {
                while (array[i].length() < maxLength) {
                    for (int j = 0; j < tmp.length-1; j++) {
                        tmp[j] = tmp[j].concat(str);
                        array[i] = "";
                        for (String elements : tmp) {
                            array[i] = array[i].concat(elements);
                        }
                        if(array[i].length() == maxLength)
                            break;
                    }
                }
            }
        }
    }
}