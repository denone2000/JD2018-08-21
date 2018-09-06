package by.it.galushka.jd01_06;

import java.util.regex.Pattern;

public class TaskC1 {

    public static String[] array = {};

    public static void main(String[] args) {
        StringBuilder poem = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("\\n");
        array = compile.split(poem);
        int maxLength = findMaxLength(array);
        alignPoem(array, maxLength);
        print(array);
    }

    private static void alignPoem(String[] array, int maxLength) {
        for (int i = 0; i < array.length; i++) {
            String[] splitArray = array[i].split(" ");
            String str = " ";
            if (array[i].length() < maxLength) {
                while (array[i].length() < maxLength) {
                    for (int j = 0; j < splitArray.length-1; j++) {
                        splitArray[j] = splitArray[j].concat(str);
                        array[i] = "";
                        for (String elements : splitArray) {
                            array[i] = array[i].concat(elements);
                        }
                        if(array[i].length() == maxLength)
                            break;
                    }
                }
            }
        }
    }

    private static void print(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
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
}