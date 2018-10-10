package by.it.voinilo.jd02.jd02_02;

public class Custom {
    static int rndAtoB(int a, int b) {
        int range = (b - a) + 1;

        int c = (int) (Math.random() * range )+ a;
        return c;
    }

}
