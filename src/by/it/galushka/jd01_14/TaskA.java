package by.it.galushka.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String getDirectory(Class<?> clss) {
        StringBuilder path = new StringBuilder();
        String dir = clss.getName().replace(".", File.separator).replace(clss.getSimpleName(), "");
        path.append(System.getProperty("user.dir")).append(File.separator);
        path.append("src" + File.separator).append(dir);
        return path.toString();
    }


    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
        try (DataOutputStream dos =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(getDirectory(TaskA.class) + "dataTaskA.bin")))
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100 + 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(getDirectory(TaskA.class) + "dataTaskA.bin")));
             PrintWriter pw =
                     new PrintWriter(
                             new FileWriter(getDirectory(TaskA.class) + "resultTaskA.txt"))
        ) {
            double sum = 0;
            double counter = 0;
            while (dis.available() > 0) {
                int i = dis.readInt();
                System.out.print(i + " ");
                pw.print(i + " ");
                sum += i;
                counter++;
            }
            System.out.println("\navg=" + sum / counter);
            pw.print("\navg=" + sum / counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
