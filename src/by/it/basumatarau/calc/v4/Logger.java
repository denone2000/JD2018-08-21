package by.it.basumatarau.calc.v4;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

class Logger {
    private static Deque<String> logHeap= new LinkedList<>();

    private static Logger instance;

    private Logger(){

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
                while (buffR.ready() && (line = buffR.readLine()) != null) {
                    if (!msg.toString().equals("") && line.matches("(^\\[input\\].*)|(^\\[error\\].*)|(^\\[output\\].*)")) {
                        logHeap.add(msg.toString());
                        if (logHeap.size() >= 50) break;
                        msg = new StringBuilder();
                        msg.append(line);
                    }else msg.append(line);
                }
                if(!msg.toString().equals("")){
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

        String date = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.MEDIUM).format(new Date());
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
            int index = 0;
            for (String message : logHeap) {
                buffW.write(String.format("%2d.%s%s", ++index, message, "\n"));
            }
        }catch (IOException e){
            e.printStackTrace(); //hm...
        }
    }

}
