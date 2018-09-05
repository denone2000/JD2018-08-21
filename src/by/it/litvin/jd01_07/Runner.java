package by.it.litvin.jd01_07;

public class Runner {
    public static void main(String[] args) {
        double[][] mValue={{1,2},{3,4}};
        Scalar scalar = new Scalar(1.2333);
        System.out.println(scalar);

        Scalar scalar2 = new Scalar(scalar);
        System.out.println(scalar2);

        Scalar scalar3 = new Scalar(1.233344);
        System.out.println(scalar3);
        /////////////////////////////////////////////

        Vector vector = new Vector(new double[]{1,2,3});
        System.out.println(vector);

        Vector vector1 = new Vector("1,2,3");
        System.out.println(vector1);

        Vector vector2 = new Vector(vector);
        System.out.println(vector);
        //////////////////////////////////////////////

        Matrix matrix=new Matrix(mValue);
        System.out.println(matrix);

        Matrix matrix1= new Matrix(new double[2][2]);
        System.out.println(matrix1);

        Matrix matrix2= new Matrix(matrix);
        System.out.println(matrix2);


    }
}
