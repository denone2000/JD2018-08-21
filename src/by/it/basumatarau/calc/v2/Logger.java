package by.it.basumatarau.calc.v2;

import java.io.*;
import java.util.LinkedList;

class Logger {
    private static LinkedList<String> logHeap= new LinkedList<>();

    public enum MsgType{
        INPUT, ERROR, OUTPUT
    }
    static {
        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"src"+System.getProperty("file.separator")
                + Logger.class.getName().replaceAll("[.]", System.getProperty("file.separator")).replaceAll(Logger.class.getSimpleName(),"");
        File file = new File(path+"log.txt");
        if(file.exists()) {
            try (BufferedReader buffR = new BufferedReader(new FileReader(file))) {
                String line;
                StringBuilder msg = new StringBuilder();
                while (buffR.ready() && (line = buffR.readLine()) != null) {
                    if (!msg.toString().equals("") && line.matches("(^\\[input\\].*)|(^\\[error\\].*)|(^\\[output\\].*)")) {
                        logHeap.add(msg.toString());
                        if (logHeap.size() > 50) break;
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
    void addMsg(String msg, MsgType type){
        if(logHeap.size()>50) {
            logHeap.remove();
        }
        switch (type){
            case INPUT:
                msg="[input]"+msg;
                break;
            case OUTPUT:
                msg="[output]"+msg;
                break;
            case ERROR:
                msg="[error]"+msg;
                break;
                default:
                    msg="[error]"+msg;
                    break;
        }
        logHeap.add(msg);

        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"src"+System.getProperty("file.separator")
                + Logger.class.getName().replaceAll("[.]", System.getProperty("file.separator")).replaceAll(Logger.class.getSimpleName(),"");
        File file = new File(path+"log.txt");

        try(BufferedWriter buffW = new BufferedWriter(new FileWriter(file))){
            for (String message : logHeap) {
                buffW.write(message+'\n');
            }
        }catch (IOException e){
            e.printStackTrace(); //hm...
        }
    }

}
