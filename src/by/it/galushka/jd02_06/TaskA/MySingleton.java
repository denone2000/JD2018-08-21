package by.it.galushka.jd02_06.TaskA;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

class MySingleton {

    private static MySingleton mySingleLink;

    private MySingleton() {
    }

    static MySingleton getMySingleton() {
        MySingleton localMySimgleLink = mySingleLink;
        if (localMySimgleLink == null) {
            synchronized (MySingleton.class) {
                localMySimgleLink = mySingleLink;
                if (localMySimgleLink == null) {
                    mySingleLink = localMySimgleLink = new MySingleton();
                }
            }
        }
        return localMySimgleLink;
    }

    synchronized void log(String message) {
        String path = getDirectory(MySingleton.class).concat("log.txt");
        Date now = new Date();
        DateFormat df = DateFormat.getDateTimeInstance();
        String dateTime = df.format(now);
        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(path, true))
        ) {
            writer.printf("[%s] - %s\n", dateTime, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getDirectory(Class<?> clss) {
        StringBuilder path = new StringBuilder();
        String dir = clss.getName().replace(".", File.separator).replace(clss.getSimpleName(), "");
        path.append(System.getProperty("user.dir")).append(File.separator);
        path.append("src").append(File.separator).append(dir);
        return path.toString();
    }
}
