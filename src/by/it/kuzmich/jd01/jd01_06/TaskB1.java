package by.it.kuzmich.jd01.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        search(Poem.text);
    }

    private static void search(String text) {
            text.trim(); Pattern compile = Pattern.compile("[а-яА-яёЁ]{2,}");
            Matcher matcher = compile.matcher(text);
            while(matcher.find()){
               String s=matcher.group();
            if (consonant(s.charAt(0))) {
                if (vowel(s.charAt(s.length() - 1))) {
                    System.out.println(s);
                } else if (s.charAt(s.length() - 1) == ',') {
                    if (vowel(s.charAt(s.length() - 2))) {
                        System.out.println(s);
                    }
                }

            }
        }
    }

    static boolean consonant(char ch) {
        boolean isTrue = false;
        ch = Character.toLowerCase(ch);
        switch (ch) {
            case 'й':
                isTrue = true;
                break;
            case 'ц':
                isTrue = true;
                break;
            case 'к':
                isTrue = true;
                break;
            case 'н':
                isTrue = true;
                break;
            case 'г':
                isTrue = true;
                break;
            case 'ш':
                isTrue = true;
                break;
            case 'щ':
                isTrue = true;
                break;
            case 'з':
                isTrue = true;
                break;
            case 'х':
                isTrue = true;
                break;
            case 'ъ':
                isTrue = true;
                break;
            case 'ф':
                isTrue = true;
                break;
            case 'в':
                isTrue = true;
                break;
            case 'п':
                isTrue = true;
                break;
            case 'р':
                isTrue = true;
                break;
            case 'л':
                isTrue = true;
                break;
            case 'д':
                isTrue = true;
                break;
            case 'ж':
                isTrue = true;
                break;
            case 'ч':
                isTrue = true;
                break;
            case 'с':
                isTrue = true;
                break;
            case 'м':
                isTrue = true;
                break;
            case 'т':
                isTrue = true;
                break;
            case 'ь':
                isTrue = true;
                break;
            case 'б':
                isTrue = true;
                break;
            default:
                isTrue = false;

        }
        return isTrue;
    }

    static boolean vowel(char ch) {
        boolean isTrue = false;
        ch = Character.toLowerCase(ch);
        switch (ch) {
            case 'ё':
                isTrue = true;
                break;
            case 'у':
                isTrue = true;
                break;
            case 'е':
                isTrue = true;
                break;
            case 'ы':
                isTrue = true;
                break;
            case 'а':
                isTrue = true;
                break;
            case 'о':
                isTrue = true;
                break;
            case 'я':
                isTrue = true;
                break;
            case 'и':
                isTrue = true;
                break;
            case 'ю':
                isTrue = true;
                break;
            default:
                isTrue = false;

        }
        return isTrue;
    }
}