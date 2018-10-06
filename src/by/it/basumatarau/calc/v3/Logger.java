package by.it.basumatarau.calc.v3;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

class Logger {
    private static LinkedList<String> logHeap= new LinkedList<>();

    public enum MsgType{
        INPUT, ERROR, OUTPUT
    }
    static {
        String path = System.getProperty("user.dir")+File.separator+"src"+File.separator
                + Logger.class.getName().replaceAll("[.]", File.separator).replaceAll(Logger.class.getSimpleName(),"");
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
                msg=new Date() + " [input]\t"+msg;
                break;
            case OUTPUT:
                msg=new Date() +"[output]\t"+msg;
                break;
            case ERROR:
                msg=new Date() +" [error]\t"+msg;
                break;
                default:
                    msg=new Date() +" [error]\t"+msg;
                    break;
        }
        logHeap.add(msg);

        String path = System.getProperty("user.dir")+File.separator+"src"+File.separator
                + Logger.class.getName().replaceAll("[.]", File.separator).replaceAll(Logger.class.getSimpleName(),"");
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
