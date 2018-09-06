package by.it.korolchuk.jd01_07;

public class Runner {


    public static void main(String[] args) {

        double[] value = {1,2,3,4};
        double[][] mValue = {{1,2},{3,4}};

        Scalar scalar = new Scalar(1.234);
        System.out.println(scalar);
        Scalar scalar2 = new Scalar(scalar);
        System.out.println(scalar2);
        Scalar scalar3 = new Scalar(1.23456789);
        System.out.println(scalar3);


        Vector vector = new Vector(value);
        System.out.println(vector);
        Vector vector2 = new Vector(vector);
        System.out.println(vector2);
        Vector vector3 = new Vector(vector);
        System.out.println(vector3);

        Matrix matrix = new Matrix(mValue);
        System.out.println(matrix);
        Matrix matrix2 = new Matrix(matrix);
        System.out.println(matrix2);
        Matrix matrix3 = new Matrix(matrix);
        System.out.println(matrix3);
    }
}
