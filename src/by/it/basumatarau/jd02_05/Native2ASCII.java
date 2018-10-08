package by.it.basumatarau.jd02_05;

import java.io.*;

public class Native2ASCII {

    public static void main(String[] args) {
        String pathSrc = getPath(args[0]);
        String pathDest = getPath(args[1]);

        File srcFile = new File(pathSrc);
        String line;

        if(srcFile.exists()){
            try(BufferedReader buffR = new BufferedReader(new FileReader(srcFile));
            BufferedWriter buffW = new BufferedWriter(new FileWriter(pathDest))){

                while((line = buffR.readLine())!=null){
                    for (Character c : line.toCharArray()) {
                        if(c<0xff){
                            buffW.write(c);
                        }else{
                            buffW.write("\\u");
                            buffW.write(Integer.toHexString(c|0xf0000).substring(1));
                        }
                    }
                    buffW.write("\n");
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("invalid srcFilename/path: "+pathSrc);
        }

    }

    private static String getPath(String arg) {
        String path;
        if(!arg.contains(File.separator)){
            path = System.getProperty("user.dir")+
                    File.separator+"src"+File.separator+ Native2ASCII.class.getName().replaceAll(Native2ASCII.class.getSimpleName(),
                    "").replace(".",File.separator)+ arg;
        }else{
            path = arg;
        }
        return path;
    }
}
