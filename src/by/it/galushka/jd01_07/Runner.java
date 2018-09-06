package by.it.galushka.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar v1 = new Scalar(3.44);
        AbstractVar v2 = new Vector(new double[]{1,2,2,3,4,5,6});
        AbstractVar v3 = new Matrix("{{1,2}, {3,4}}");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }
}
