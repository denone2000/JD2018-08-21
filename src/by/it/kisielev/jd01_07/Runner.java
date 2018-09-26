package by.it.kisielev.jd01_07;

public class Runner {
    public  static void main(String[] args){
        Scalar scalar=new Scalar(1.12334);
        System.out.println(scalar);

        Scalar scalar2=new Scalar(scalar);
        System.out.println(scalar2);

        Scalar scalar3=new Scalar("1.23456789");
        System.out.println(scalar3);
    }
}
