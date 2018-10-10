package by.it.litvin.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private static Logger instance;

    private Logger() {
    }

    static Logger getInstance() {

        if (instance == null)
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        return instance;
    }

    synchronized void log(String message) {
        String path = System.getProperty("user.dir");
        path = path.concat("/src/by/it/litvin/jd02_06/log.txt");

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(message);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

