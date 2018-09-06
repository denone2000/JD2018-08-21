package by.it.bindyuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static char[] wordsGlas = {'а', 'е', 'ё', 'и', 'о', 'у', 'э', 'ю', 'я', 'ы'};
    private static char[] wordsSoglas = {'б', 'Б', 'в', 'В', 'г', 'Г', 'д', 'Д', 'ж', 'Ж', 'з', 'З',
            'к', 'К', 'л', 'Л', 'м', 'М', 'н', 'Н', 'п', 'П', 'р', 'Р', 'с', 'С', 'т', 'Т', 'ф', 'Ф', 'х', 'Х',
            'ц', 'Ц', 'ч', 'Ч', 'ш', 'Ш', 'щ', 'Щ'};

    private static void process(String word) {
        char[] myCharArray = word.toCharArray();
        for (int i = 0; i < wordsSoglas.length; i++) {
            if (myCharArray[0] == wordsSoglas[i]) {
                for (int j = 0; j < wordsGlas.length; j++) {
                    if (myCharArray[myCharArray.length - 1] == wordsGlas[j]) {
                        System.out.println(word);
                    }
                }
            }
        }
            }

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher = compile.matcher(sb1);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }
    }
}







