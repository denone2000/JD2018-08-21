package by.it.kuzmich.JD_01_06;

import java.util.regex.Pattern;

/**
 * Created by user on 01.09.2018.
 */
public class TaskA {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        //Pattern.compile()
        System.out.println(sb);
        sb.setCharAt(1,'#');
    }

}
