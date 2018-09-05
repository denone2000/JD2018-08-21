package by.it.korolchuk.jd01_06;


public class TaskB1 {
    public static void main(String[] args) {

        findWord(Poem.text);
    }

    private static void findWord(String text) {
        String[] words = text.split("[,;:.!?\\s]+");
        String vowels = "АаЯяЕеЁёИиЫыОоУуЮюЭэ";
        String consonants = "БбВвГгДдЖжЗзКкЛлМмНнПпРрСсТтФфХхЦцЧчШшЩщЬь";

        for (String word : words) {
            char[] wordChars = word.toCharArray();
            if (contains(consonants, wordChars[0]) && contains(vowels, wordChars[wordChars.length - 1])) {
                System.out.println(word);
            }
        }
    }

    public static boolean contains(String str, char chr) {
        return str.indexOf(chr) != -1;
    }
}


