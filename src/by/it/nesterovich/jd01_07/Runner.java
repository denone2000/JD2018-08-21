package by.it.nesterovich.jd01_07;

public class Runner {

    public static void main(String[] args) {
        //AbstractVar scalar1 = new Scalar(3.1415);
        //System.out.println(scalar1);
        //AbstractVar scalar2 = new Scalar((Scalar) scalar1);
        //System.out.println(scalar2);
        //AbstractVar scalar3 = new Scalar("3.1415");
        //System.out.println(scalar3);

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
