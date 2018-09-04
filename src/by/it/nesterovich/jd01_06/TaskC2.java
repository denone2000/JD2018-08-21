package by.it.nesterovich.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        long startSlow =System.currentTimeMillis();//System.nanoTime();
        System.out.println(slow(Poem.text));
        long endSlow = System.currentTimeMillis();
        long startFast =System.currentTimeMillis();
        System.out.println(fast(Poem.text));
        long endFast = System.currentTimeMillis();
        System.out.println("Время затраченное на метод slow: "+(endSlow-startSlow));
        System.out.println("Время затраченное на метод fast: "+(endFast-startFast));
    }

    private static String slow(String text) {
        String result = "";
        Pattern patternWord = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher match = patternWord.matcher(text);
        String[] arrayWord = {};
        while (match.find()) {
            String word = match.group();
            arrayWord = Arrays.copyOf(arrayWord, arrayWord.length + 1);
            arrayWord[arrayWord.length - 1] = word;
        }
        Random random = new Random(arrayWord.length);
        do {
            int randomIndex = random.nextInt(arrayWord.length);
            result = result + arrayWord[randomIndex]+" ";
        } while (result.length() < 100000);
        return result;
    }

    private static String fast(String text) {
        StringBuilder result = new StringBuilder();
        Pattern patternWord = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher match = patternWord.matcher(text);
        String[] arrayWord = {};
        while (match.find()) {
            String word = match.group();
            arrayWord = Arrays.copyOf(arrayWord, arrayWord.length + 1);
            arrayWord[arrayWord.length - 1] = word;
        }
        Random random = new Random(arrayWord.length);
        do {
            int randomIndex = random.nextInt(arrayWord.length);
            result.append(arrayWord[randomIndex]+" ");
        } while (result.length() < 100000);
        return new String(result);
    }
}
