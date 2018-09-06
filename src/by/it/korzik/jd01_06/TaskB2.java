package by.it.korzik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String[] sent = textFormat();
        sent =textSort(sent);
        for (String s : sent) {
            System.out.print(s+"\n");
        }

    }

    private static String[] textSort(String[] sent) {
        String tmp;
        for (int j = sent.length - 1; j >= 0; j--) {
            for (int i = 0; i < sent.length - 1; i++)
                if (sent[i].length() >= sent[i + 1].length()) {
                    tmp=sent[i];
                    sent[i]=sent[i+1];
                    sent[i+1]=tmp;
                }

        }
        return sent;

    }

    private static String[] textFormat() {

        String[] sent = Poem.text.trim().replace("...","").split("\\.");
        for (int j = 0; j < sent.length; j++) {
            Pattern compile = Pattern.compile("\\s");
            Matcher matcher = compile.matcher(sent[j]);
            while (matcher.find()) {
                sent[j] = sent[j].replaceAll("\\s", " ");
                sent[j] = sent[j].trim();
            }
            Pattern compil = Pattern.compile("\\p{Punct}");
            Matcher matche = compil.matcher(sent[j]);
            while (matche.find()) {
                sent[j] = sent[j].replaceAll("\\p{Punct}", " ");
                sent[j] = sent[j].trim();
            }
            Pattern compi = Pattern.compile("\\s+");
            Matcher match = compi.matcher(sent[j]);
            while (match.find()) {
                sent[j] = sent[j].replaceAll("\\s+", " ");
                sent[j] = sent[j].trim();
            }
        }

        return sent;
    }
}
