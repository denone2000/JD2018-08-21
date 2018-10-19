package by.it.yaroshchuk.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private static Logger instance;

    private Logger(){

    }

    static Logger getInstance(){
        if(instance == null) {
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    synchronized void log(String message) {
        String path = System.getProperty("user.dir");
        path = path.concat("/src/by/it/yaroshchuk/jd02_06/log.txt");

        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))) {
            out.println(message);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
