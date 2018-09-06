package by.it.artemliashkov.jd01_06;

import java.util.Random;
import java.util.regex.Pattern;

public class TaskC2 {
    private static String fast(String src) {
       StringBuilder result = new StringBuilder();
       Pattern anyWord = Pattern.compile("[^а-яА-ЯёЁ]+");
       String[] stringPool = anyWord.split(src);
       Random rnd = new Random(stringPool.length);
       do {
          int rndPoolNum = rnd.nextInt() % stringPool.length;
          result.append(stringPool[rndPoolNum>0?rndPoolNum:rndPoolNum*(-1)]).append(" ");
       }while (result.length()<100000);
       return new String(result);
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(slow(Poem.text));
        long finish1 = (System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(fast(Poem.text));
        long finish2 = (System.nanoTime() - start);
        System.out.println("slow run time=" + finish1/1.0e6 + "ms");
        System.out.println("fast run time=" + (System.nanoTime() - start)/1.0e6 + "ms");
    }
    private static String slow(String src) {
        String result = new String();
        Pattern anyWord = Pattern.compile("[^а-яА-ЯёЁ]+");
        String[] stringPool = anyWord.split(src);
        Random rnd = new Random(stringPool.length);
        do {
            int rndPoolNum = rnd.nextInt() % stringPool.length;
            result = result+stringPool[rndPoolNum>0?rndPoolNum:rndPoolNum*(-1)] + " ";
        }while (result.length()<100000);
        return result;
    }
}
