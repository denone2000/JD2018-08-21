package by.it.basumatarau.calc.v4;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;

class Logger {
    private static Deque<String> logHeap= new LinkedList<>();
    private static Date statrtTime;
    private static Logger instance;

    private Logger(){
        statrtTime = new Date();
        try(BufferedWriter buffW = new BufferedWriter(
                new FileWriter(getPath()+"log.txt")
        )
        ){
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
            buffW.write("[session start]"+sdf.format(statrtTime)+"\n");
            for (String message : logHeap) {
                buffW.write(String.format("%s%s", message, "\n"));
            }
        }catch (IOException e){
            e.printStackTrace(); //hm...
        }
    }
    public static Logger getInstance(){
        if (instance==null){
            synchronized (Logger.class){
                if(instance == null){
                    instance= new Logger();
                }
            }
        }
        return instance;
    }

    public enum MsgType{
        INPUT, ERROR, OUTPUT
    }
    static {
        File file = new File(getPath()+"log.txt");
        if(file.exists()) {
            try (BufferedReader buffR = new BufferedReader(new FileReader(file))) {
                String line;
                StringBuilder msg = new StringBuilder();
                boolean isLogged = false;
                while (buffR.ready() && (line = buffR.readLine()) != null) {
                    if (line.matches("(^\\[input\\].*)|(^\\[error\\].*)|(^\\[output\\].*)")) {
                        if(isLogged) logHeap.add(msg.toString());

                        isLogged = true;
                        msg = new StringBuilder();
                        msg.append(line);
                    }else {
                        if(line.matches("^\\[session start\\].*")) isLogged=false;

                        if(isLogged) msg.append(line);
                    }
                }
                if(isLogged){
                    logHeap.add(msg.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getPath() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + Logger.class.getName().replaceAll("[.]", File.separator).replaceAll(Logger.class.getSimpleName(), "");
    }

    synchronized void addMsg(String msg, MsgType type){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);

        String date = sdf.format(new Date());
        switch (type){
            case INPUT:
                msg=String.format("%s %s: %s","[input]: ", date, msg);
                break;
            case OUTPUT:
                msg=String.format("%s %s: %s","[output]:", date, msg);
                break;
            case ERROR:
                msg=String.format("%s %s: %s","[error]: ", date, msg);
                break;
            default:
                msg=String.format("%s %s: %s","[error]: ", date, msg);
                break;
        }

        if(logHeap.size()>=50) {
            logHeap.pop();
        }
        logHeap.addLast(msg);

        try(BufferedWriter buffW = new BufferedWriter(
                new FileWriter(getPath()+"log.txt")
            )
        ){
            buffW.write("[session start]"+sdf.format(statrtTime)+"\n");
            for (String message : logHeap) {
                buffW.write(String.format("%s%s", message, "\n"));
            }
        }catch (IOException e){
            e.printStackTrace(); //hm...
        }
    }

}
