package by.it.basumatarau.jd01_15;

import java.io.*;

public class TaskB {

    /**
     * @author basumatarau
     *
     * //* /* //
     * this is a javadoc comment
     */

    //this is a single line comment#1

    public static void main(String[] args) {
        //this is a single line comment#2

        /*
         *this is a multiline comment
         */
        File f = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+
                "src"+System.getProperty("file.separator")+TaskB.class.getName().
                replaceAll("[.]", System.getProperty("file.separator"))+".java");
        StringBuilder sb = new StringBuilder();
        try(BufferedReader buffR = new BufferedReader(new FileReader(f))){
            char ch, chFrw;
            boolean isSingleLineComment = false;
            boolean isMultilineComment = false;
            while(buffR.ready()){
                ch=(char)buffR.read();
                if(isMultilineComment){
                    if(ch=='*'){
                        if(buffR.ready()&&((char)buffR.read())=='/'){
                            isMultilineComment = false;
                            continue;
                        }else{
                            continue;
                        }
                    }else continue;
                }else {
                    if(!isSingleLineComment){
                        if(ch=='/'){
                            if(buffR.ready()){
                                chFrw=(char)buffR.read();
                                if (chFrw=='/'){
                                    isSingleLineComment=true;
                                    continue;
                                }else if(chFrw=='*'){
                                    isMultilineComment=true;
                                    continue;
                                }else{
                                    sb.append(ch).append(chFrw);
                                    continue;
                                }
                            }else {
                                sb.append(ch);
                                continue;
                            }
                        }else {
                            sb.append(ch);
                            continue;
                        }
                    }
                }

                if(ch=='\n'){
                    sb.append(ch);
                    isSingleLineComment=false;
                }else if(ch=='/'&&buffR.ready()){
                    if((chFrw=(char)buffR.read())!='/'){
                        sb.append(ch).append(chFrw);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        f = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+
                TaskB.class.getName().replaceAll("[.]", System.getProperty("file.separator"))+".txt");
        try(BufferedWriter buffW = new BufferedWriter(new FileWriter(f))){
            buffW.write(sb.toString());
            System.out.println(sb.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
