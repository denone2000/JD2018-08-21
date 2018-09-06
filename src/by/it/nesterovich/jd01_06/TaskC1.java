package by.it.nesterovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern patternSplit = Pattern.compile("\n");
        String[] strings = patternSplit.split(sb);
        printArrayStringWithWidthEqualization(strings);
    }

    private static void printArrayStringWithWidthEqualization(String[] strings) {
        int width = 0;
        for (String element : strings) {
            if (element.length() > width) {
                width = element.length();
            }
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() < width) {
                int deltaWidth = width - strings[i].length();
                int numberSpaceInString = countSpaceInString(strings[i]);
                int numberSpaceOnAllWidth = deltaWidth / numberSpaceInString;
                int numberSpaceNotOnAllWidth = deltaWidth % numberSpaceInString;
                strings[i] = lineWidthAlignment(strings[i], numberSpaceInString, numberSpaceOnAllWidth, numberSpaceNotOnAllWidth);
            }
        }
        String text = "";
        for (int i = 0; i < strings.length; i++) {
            text = text + strings[i] + "\n";
        }
        System.out.println(text);
    }

    private static String lineWidthAlignment(String str, int numberSpaceInString, int addSpaceOnAllWidth, int addSpaceNotOnAllWidth) {

        int[] index = new int[numberSpaceInString];
        Pattern patternSpace = Pattern.compile(" ");
        Matcher match = patternSpace.matcher(str);
        for (int i = 0; i < index.length; i++) {
            if (match.find()) {
                index[i] = match.start();
            }
        }
        String addSpace = "";
        for (int i = 0; i < addSpaceOnAllWidth; i++) {
            addSpace = addSpace + " ";
        }
        String addOneSpace = "";
        if (addSpaceNotOnAllWidth > 0) {
            addOneSpace = addOneSpace + " ";
        }
        String string = str.substring(0, index[0]) + addSpace;
        int countAddOneSpace = 0;
        for (int i = 0; i < index.length - 1; i++) {
            if (countAddOneSpace < addSpaceNotOnAllWidth) {
                string = string + addOneSpace;
                countAddOneSpace++;
            }
            string = string + str.substring(index[i], index[i + 1]) + addSpace;
        }
        string = string + str.substring(index[index.length - 1], str.length());
        return string;
    }

    private static int countSpaceInString(String str) {
        int count = 0;
        Pattern patternSpace = Pattern.compile(" ");
        Matcher match = patternSpace.matcher(str);
        while (match.find()) {
            count++;
        }
        return count;
    }


}
