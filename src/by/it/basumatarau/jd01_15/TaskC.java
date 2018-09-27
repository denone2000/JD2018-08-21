package by.it.basumatarau.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskC {
    private static String currentDir = System.getProperty("user.dir")+ File.separator+
            "src"+File.separator+TaskC.class.getName().
            replace(".", File.separator).replaceAll(File.separator
            +TaskC.class.getSimpleName(),"");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        System.out.print(currentDir+":");
        while(!(line=scanner.nextLine()).toLowerCase().contains("end")){
            if(line.matches("^cd\\s*.*")){
                cd(line);
            }else if(line.matches("^dir\\s*.*")){
                dir();
            }else {
                System.out.println(currentDir+":" + line+" is not a command...");
                System.out.print(currentDir+":");
            }
        }
    }

    private static void dir() {
        Path p = Paths.get(currentDir);
        try (Stream<Path> list = Files.list(p)) {
            for (String strFileAttr : list.map(path -> {
                BasicFileAttributes att = null;
                try {
                    att = Files.readAttributes(path, BasicFileAttributes.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (att != null) {
                    NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
                    DateFormat df = DateFormat.getDateInstance();
                    return String.format("%12s %15s %s",
                            df.format(att.creationTime().toMillis()),
                            //att.creationTime().toString().substring(0,19).replace("T", " "),
                            (att.isDirectory() ? "<DIR>" : String.format("%s",nf.format(att.size()))),
                            path.getFileName());
                } else return "<can't access attributes>"+'\t' + path.getFileName();
            }).collect(Collectors.toList())) {
                System.out.println(strFileAttr);
            }
            NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
            System.out.printf("%19d File(s) %15s bytes\n",(Files.list(p).filter(path->!Files.isDirectory(path)).count()),
                    nf.format(Files.list(p).filter(path->!Files.isDirectory(path)).map(path -> {
                BasicFileAttributes att = null;
                try {
                    att = Files.readAttributes(path, BasicFileAttributes.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return att!=null?att.size():0;
            }).reduce(0L,(item1,item2)->item1+item2)));
            System.out.printf("%19d Dir(s)  %15s bytes free\n",(Files.list(p).filter(path->Files.isDirectory(path)).count()),
                    nf.format(Files.getFileStore(p).getUsableSpace()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(currentDir+":");
    }

    private static void cd(String line) {
        if(line.matches("^cd\\s[.][.]\\s*")){
            Path p = Paths.get(currentDir);
            currentDir = p.getParent().toAbsolutePath().toString();
        }else if(line.matches("^cd\\s.*")){
            line = line.substring(3).trim();
            if(line.matches("^["+File.separator+"].*")) {
                Path p = Paths.get(line);
                if (Files.exists(p)) {
                    if (Files.isDirectory(p)) {
                        currentDir = p.toAbsolutePath().toString();
                    } else System.out.printf("%s is not a directory \n", line);
                } else {
                    System.out.printf("there is nothing at %s \n", line);
                }
            }else{
                Path p = Paths.get(currentDir+File.separator+line);
                if (Files.exists(p)) {
                    if (Files.isDirectory(p)) {
                        currentDir = p.toAbsolutePath().toString();
                    } else System.out.printf("%s is not a directory \n", currentDir+File.separator+line);
                } else {
                    System.out.printf("there is nothing at %s \n", currentDir+File.separator+line);
                }
            }
        }
        System.out.print(currentDir+":");
    }
}
