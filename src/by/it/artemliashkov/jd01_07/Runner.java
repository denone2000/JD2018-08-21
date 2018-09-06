package by.it.artemliashkov.jd01_07;

public class Runner {
    public static void main (String args[])
    {
        Scalar scalar=new Scalar(1.234);
        System.out.println(scalar.toString());
        Scalar scalar2=new Scalar(1.234);
        System.out.println(scalar2.toString());
        Scalar scalar3=new Scalar(1.234);
        System.out.println(scalar3.toString());
        AbstractVar vector1 = new Vector(new double[]{1, 2, 3});
        System.out.println(vector1);
        AbstractVar vector2 = new Vector((Vector) vector1);
        System.out.println(vector2);
        AbstractVar vector3 = new Vector("{1, 2, 3}");
        System.out.println(vector3);
        AbstractVar matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        System.out.println(matrix1);
        AbstractVar matrix2 = new Matrix((Matrix) matrix1);
        System.out.println(matrix2);
        AbstractVar matrix3 = new Matrix("{{1,2},{3,4}}");
        System.out.println(matrix3);
    }
}
