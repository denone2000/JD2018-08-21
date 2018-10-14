package by.it.nesterovich.jd02_09.task_c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class PrintToConsole {

    static void printFile(File file) {
        String path = String.valueOf(file);
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader(path))
        ) {
            StringBuilder text = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                text.append(line).append('\n');
                line = bufferedReader.readLine();
            }
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
