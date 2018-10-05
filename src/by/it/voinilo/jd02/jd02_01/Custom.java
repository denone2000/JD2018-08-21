package by.it.voinilo.jd02.jd02_01;

public class Custom {
    static int rndAtoB(int a, int b) {
        int range = (b - a) + 1;

        int c = (int) (Math.random() * range + a);
        return c;
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 10000; i++) {
//
//        int a;
//
//            a = Custom.rndAtoB(-6, 5);
//            if (a==-6) {
//                System.out.println(a);
//            }
//        }
//    }
    //why there's no -6?
}
