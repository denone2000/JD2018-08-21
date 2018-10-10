package by.it.korolchuk.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

class CalcLogger {
    private static CalcLogger instance;
    private static LinkedList<String> logList = new LinkedList<>();
    private CalcLogger() {

    }

    static CalcLogger getInstance() {
        if (instance == null) {
            synchronized (CalcLogger.class) {
                if (instance == null)
                    instance = new CalcLogger();
            }
        }
        return instance;
    }


    synchronized void log (String message) {
        String path = System.getProperty("user.dir");
        path = path.concat("/src/by/it/korolchuk/jd02_06/Calc_log/log.txt");

        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))){
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
