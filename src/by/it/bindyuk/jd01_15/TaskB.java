package by.it.bindyuk.jd01_15;

import java.io.*;

/**
 * @author by bindyuk
 */

public class TaskB {
    public static void main(String[] args) {
        String a = "pullpullpull";
        int b = 42; // it's comment one
            /*
             comment
             comment i love tim kook
             */
        int c = 523;
        int row = 321; // its comment two

        String s = "comment";
            /*
             many-rows comment
             comment
             i love tim kook
             */
        double a1 = 0.42;

        String fileNameRead = System.getProperty("user.dir") + "/src/by/it/bindyuk/jd01_15/TaskB.java";
        String fileNameWrite = System.getProperty("user.dir") + "/src/by/it/bindyuk/jd01_15/TaskB.txt";

        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameRead));
             PrintWriter writer = new PrintWriter(new FileWriter(fileNameWrite))) {

            char one;
            char two;
            boolean lineComment = false;
            boolean manyComment = false;

            while (reader.ready()) {
                one = (char) reader.read();
//если однострочный комментарий
                if (lineComment) {
                    if (one != '\n') continue;
                    else lineComment = false;
                }
//если многострочный коммент
                if (manyComment) {

                    if (one != '*') {
                        continue;
                    }
                    if (one == '*') {
                        two = (char) reader.read();
                        if (two == '/') {
                            manyComment = false;
                            continue;
                        } else if (two != '/') {
                            continue;
                        }
                    }
                }
//здесь решаем что это, однострочный коммент, многострочный или просто слэш
                if (one == '/') {
                    two = (char) reader.read();
                    if (reader.ready() && two == '/') {
                        lineComment = true;
                    } else if (reader.ready() && two == '*') {
                        manyComment = true;
                    } else if (reader.ready() && two != '/' && two != '*') {
                        sb.append(one).append(two);
                    }

                } else sb.append(one);
            }
            System.out.println(sb.toString());
            writer.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

