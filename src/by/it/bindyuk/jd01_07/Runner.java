package by.it.bindyuk.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar = new Scalar(3.1415);
        System.out.println(scalar);

        Scalar scalar1 = new Scalar(scalar);
        System.out.println(scalar1);

        Scalar scalar2 = new Scalar("3.141511");
        System.out.println(scalar2);

        double [] mas = {1,2,4};
        Vector vector = new Vector(mas);
        System.out.println(vector);

        Vector vector1 = new Vector(vector);
        System.out.println(vector1);

        Vector vector2 = new Vector("{1,2,4}");
        System.out.println(vector2);

    }
}






















//    Scalar scalar = new Scalar(1.2);
//        System.out.println(scalar);
//
//        Scalar scalar2 = new Scalar(scalar);
//        System.out.println(scalar2);
//
//        Scalar scalar3 = new Scalar("1.23213");
//        System.out.println(scalar3);