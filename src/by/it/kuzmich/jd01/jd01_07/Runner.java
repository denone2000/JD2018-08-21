package by.it.kuzmich.jd01.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scal = new Scalar(3.3452);
        System.out.println(scal.toString());
        Scalar scalar=new Scalar(scal);
        Scalar scalar2 = new Scalar("215.2");
        double[] arrVar ={3.3,4.4,5.5,32.5,12.4};
        double[][] matrix={{2,3,3.3},{1,23,4.3}};
        Vector vec = new Vector(arrVar);
        Vector vec2 = new Vector(vec);
        Vector vec3 = new Vector("1,2,3,4,5,6,45.4,43.5");
    }
}
