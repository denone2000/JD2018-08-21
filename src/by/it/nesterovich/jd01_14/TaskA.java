package by.it.nesterovich.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskA {

    public static void main(String[] args) {

        //write int
        try (DataOutputStream dos =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin")))
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 111));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read int
        ArrayList<Integer> list = new ArrayList<>();
        try (DataInputStream dis =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));
             PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))
        ) {
            double sum = 0;
            while (dis.available() > 0) {
                int i = dis.readInt();
                list.add(i);
                System.out.print(i + " ");
                sum += i;
            }
            System.out.println("\navg=" + sum / list.size());
            out2.print("\navg=" + sum / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
}
