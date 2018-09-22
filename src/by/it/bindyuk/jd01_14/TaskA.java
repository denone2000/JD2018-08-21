package by.it.bindyuk.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream
                        (new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin")))) {

            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 420));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> list = new ArrayList<>();
        double sum = 0;

        try (DataInputStream inp = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));
        PrintWriter out = new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt")))
        {

            while (inp.available() > 0) {
                int i = inp.readInt();
                System.out.print(i + " ");
                out.print(i+ " ");
                list.add(i);
                sum += i;
            }
            System.out.println("\navg="+sum/list.size());
            out.print("\navg="+sum/list.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
