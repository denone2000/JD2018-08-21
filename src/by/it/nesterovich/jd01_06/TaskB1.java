package by.it.nesterovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String[] words = {};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
            fillArrayWord(word);
        }
        searchWord(words);
    }

    private static void fillArrayWord(String word) {
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
    }

    private static void searchWord(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 1) {
                char firstChar = words[i].charAt(0);
                char lastChar = words[i].charAt(words[i].length() - 1);

                if ((lastChar == 'а' || lastChar == 'е' || lastChar == 'ё' || lastChar == 'и' || lastChar == 'о' ||
                        lastChar == 'у' || lastChar == 'ы' || lastChar == 'э' || lastChar == 'ю' || lastChar == 'я') &&
                        (firstChar == 'й' || firstChar == 'ц' || firstChar == 'к' || firstChar == 'н' || firstChar == 'г' || firstChar == 'ш' || firstChar == 'щ' ||
                                firstChar == 'з' || firstChar == 'х' || firstChar == 'ф' || firstChar == 'в' || firstChar == 'п' || firstChar == 'р' || firstChar == 'л' ||
                                firstChar == 'д' || firstChar == 'ж' || firstChar == 'ч' || firstChar == 'с' || firstChar == 'м' || firstChar == 'т' || firstChar == 'б' ||
                                firstChar == 'Й' || firstChar == 'Ц' || firstChar == 'К' || firstChar == 'Н' || firstChar == 'Г' || firstChar == 'Ш' || firstChar == 'Щ' ||
                                firstChar == 'З' || firstChar == 'Х' || firstChar == 'Ф' || firstChar == 'В' || firstChar == 'П' || firstChar == 'Р' || firstChar == 'Л' ||
                                firstChar == 'Д' || firstChar == 'Ж' || firstChar == 'Ч' || firstChar == 'С' || firstChar == 'М' || firstChar == 'Т' || firstChar == 'Б')) {
                    System.out.println(words[i]);
                }
            }
        }
    }
}
