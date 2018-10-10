package by.it.bindyuk.jd02_06.calcV3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

class Logger {

    private static Logger instance;

    private Logger() {
    }

    static Logger getInstance() {

        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    synchronized void log(String message) {
        String path = System.getProperty("user.dir") + "/src/by/it/bindyuk/jd02_06/calcV3/txt/log.txt";
        Date date = new Date();
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(date.toString() + " : " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
