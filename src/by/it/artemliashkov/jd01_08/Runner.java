package by.it.artemliashkov.jd01_08;

public class Runner {
    public static void main (String args[])
    {
        Scalar scalar=new Scalar(1.234);
        System.out.println(scalar.toString());
        Scalar scalar2=new Scalar(1.234);
        System.out.println(scalar2.toString());
        Scalar scalar3=new Scalar(1.234);
        System.out.println(scalar3.toString());
        Var vector1 = new Vector(new double[]{1, 2, 3});
        System.out.println(vector1);
        Var vector2 = new Vector((Vector) vector1);
        System.out.println(vector2);
        Var vector3 = new Vector("{1, 2, 3}");
        System.out.println(vector3);
        Var matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        System.out.println(matrix1);
        Var matrix2 = new Matrix((Matrix) matrix1);
        System.out.println(matrix2);
        Var matrix3 = new Matrix("{{1,2},{3,4}}");
        System.out.println(matrix3);
    }
}
