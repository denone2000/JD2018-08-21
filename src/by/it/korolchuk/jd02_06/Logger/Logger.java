package by.it.korolchuk.jd02_06.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private static Logger instance;
    //private PrintWriter out;
    private Logger() {

    }

    static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }


    synchronized void log (String message) {
        String path = System.getProperty("user.dir");
        path = path.concat("/src/by/it/korolchuk/jd02_06/Logger/log.txt");

        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))){
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
