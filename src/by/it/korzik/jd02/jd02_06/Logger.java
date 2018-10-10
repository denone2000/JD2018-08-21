package by.it.korzik.jd02.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {

    private static Logger logger;

    private Logger(){

    }

    static Logger getLogger() {
        if (logger==null){
            synchronized (Logger.class){
                if (logger==null){
                    logger=new Logger();
                }
            }
        }
        return logger;
    }


    void log(String msg) {
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/korzik/jd02/jd02_06/";
        path = path.replaceAll("\\\\","/").trim();
        String txtPath = path+"log.txt";
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(txtPath, true))){
        printWriter.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
