package by.it.ausiyevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 { public static void main(String[] args) {
    StringBuilder text = new StringBuilder(Poem.text);

    Pattern splitter = Pattern.compile("((?<![\\.])[\\.](?![\\.]))");
    String[] splitStrings = splitter.split(text);

    Pattern replacer = Pattern.compile("([^а-яА-ЯёЁ]+)");
    Matcher matcherObj = replacer.matcher("");

    for (int i = 0; i < splitStrings.length; i++) {
        matcherObj.reset(splitStrings[i]);
        splitStrings[i] = matcherObj.replaceAll(" ").trim();
    }
    splitStrings=arraySort(splitStrings);

    StringBuilder string = new StringBuilder();
    for (int i = 0; i < splitStrings.length; i++) {
        string.append(splitStrings[i]).append('\n');
    }
    System.out.println(string);
}
    private static String[] arraySort(String[] array) {
        return mergeSort(array, 0, array.length-1);
    }

    private static String[] mergeSort(String[] array, int l, int r) {
        if (l>=r) {
            return new String[]{array[l]};
        }else {
            String[] left = mergeSort(array, l, (l + r) / 2);
            String[] right = mergeSort(array, (l + r) / 2 + 1, r);
            return merge(left, right);
        }
    }
    private static String[] merge(String[] left, String[] right) {
        int ptr1= 0, ptr2=0, currentPtr =0;
        String[] result = new String[left.length+right.length];
        while(ptr1<left.length && ptr2<right.length){
            result[currentPtr++] = left[ptr1].length()<right[ptr2].length() ? left[ptr1++]: right[ptr2++];
        }
        while (ptr1!=left.length) result[currentPtr++] = left[ptr1++];
        while (ptr2!=right.length) result[currentPtr++] = right[ptr2++];

        return result;
    }
}
