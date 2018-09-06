package by.it.basumatarau.jd01_08;

public class Runner {
    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var v = new Vector("{1.0, 2.0, 3.0}");
        Matrix m = new Matrix("{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}");

        System.out.println(s.add(s));
        System.out.println(s.sub(s));
        System.out.println(s.mul(s));
        System.out.println(s.div(s));

        System.out.println(v.add(v));
        System.out.println(v.sub(v));
        System.out.println(v.mul(v));
        System.out.println(v.div(v));

        System.out.println(m.add(m));
        System.out.println(m.sub(m));
        System.out.println(m.mul(m));
        System.out.println(m.div(m));

        System.out.println(s.sub(m));
    }
}
