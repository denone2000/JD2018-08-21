package by.it.nesterovich.jd02_09.task_c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class ReadFile {

    static String readFile(File file) {
        String path = String.valueOf(file);
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader(path))
        ) {
            String line = bufferedReader.readLine();
            while (line != null) {
                text.append(line).append('\n');
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(text);
    }
}
