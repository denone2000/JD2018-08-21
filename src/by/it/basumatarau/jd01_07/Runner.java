package by.it.basumatarau.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalarOb = new Scalar(1.234);
        System.out.println(scalarOb);
        Scalar scalarOb2 = new Scalar(scalarOb);
        System.out.println(scalarOb2);
        Scalar scalarObj3 = new Scalar("1.253");
        System.out.println(scalarObj3);
        String vectStr = "{1.5, 2.2, 3.2, 4.0}";
        Vector vect = new Vector(vectStr);
        System.out.println(vect);
    }
}
