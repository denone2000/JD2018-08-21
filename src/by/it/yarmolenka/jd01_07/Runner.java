package by.it.yarmolenka.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar scalar=new Scalar(1.2334);
        System.out.println(scalar);

       /* Scalar scalar2=new Scalar(scalar);
        System.out.println(scalar2);

        Scalar scalar3=new Scalar("1.23456789");
        System.out.println(scalar3);
        */
       AbstractVar vector=new Vector(new double[] {1,2,3});
        System.out.println(vector);
    }
}
