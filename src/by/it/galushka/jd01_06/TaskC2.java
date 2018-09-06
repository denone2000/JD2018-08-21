package by.it.galushka.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {

    public static void main(String[] args) {
        String poem = Poem.text;
        long startTimerSlow = System.nanoTime();
        String slowResult = slow(poem);
        long timerSlowResult = System.nanoTime() - startTimerSlow;
        long startTimerFast = System.nanoTime();
        String fastResult = fast(poem);
        long timerFastResult = System.nanoTime() - startTimerFast;
        System.out.println(slowResult);
        System.out.println(fastResult);
        System.out.println(timerSlowResult/1000);
        System.out.println(timerFastResult/1000);
    }

    static String slow(String text) {
        Pattern compile = Pattern.compile("[А-яЁё]+");
        Matcher matcher = compile.matcher(text);
        String[] arrayByWords = {};
        while (matcher.find()) {
            String group = matcher.group();
            arrayByWords = Arrays.copyOf(arrayByWords, arrayByWords.length+1);
            arrayByWords[arrayByWords.length-1] = group;
        }
        String longString = "";
        int min = 100000;
        Random random = new Random(arrayByWords.length);
        while (longString.length() < min) {
            int randomIndex = random.nextInt(arrayByWords.length);
            longString = longString.concat(arrayByWords[randomIndex] + " ");
        }
        return longString.trim();
    }

    static String fast(String text) {
        Pattern compile = Pattern.compile("[А-яЁё]+");
        Matcher matcher = compile.matcher(text);
        String[] arrayByWords = {};
        while (matcher.find()) {
            String group = matcher.group();
            arrayByWords = Arrays.copyOf(arrayByWords, arrayByWords.length+1);
            arrayByWords[arrayByWords.length-1] = group;
        }
        StringBuilder longString = new StringBuilder();
        int min = 100000;
        Random random = new Random(arrayByWords.length);
        while (longString.length() < min) {
            int randomIndex = random.nextInt(arrayByWords.length);
            longString.append(arrayByWords[randomIndex] + " ");
        }
        String result = longString.toString();
        return result.trim();
    }
}
