package by.it.artemliashkov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        StringBuilder poem=new StringBuilder(Poem.text);
        boolean lastChar=true;
        for (int i = 0; i <poem.length() ; i++) {
            char ch=poem.charAt(i);
            if (lastChar && Character.isAlphabetic(ch)){
                sb.append(ch);
            }else if (!lastChar && Character.isAlphabetic(ch)){
                sb.append(" ").append(ch);
                lastChar = true;
            } else lastChar=false;
        }
        String[] heap = new String(sb).split(" ");
        for (int i = 0; i < heap.length; i++) {
            if(!"ауоыиэяюёе".contains(""+heap[i].toLowerCase().charAt(0))&&
                    "ауоыиэяюёе".contains(""+heap[i].toLowerCase().charAt(heap[i].length()-1))) {
                System.out.println(heap[i]);
            }
        }
    }
}