package by.it.galushka.jd01_15;

public class tmp {
    public static void main(String[] args) {
        int[] test = new int[500];
        for (int num : test) {
            num = (int)(Math.random()*32-16);
            System.out.println(num);
        }
    }
}
