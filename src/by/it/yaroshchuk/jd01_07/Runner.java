package by.it.yaroshchuk.jd01_07;

class Runner {
    public static void main(String[] args) {
        AbstractVar v1 = new Scalar(3.14);
        AbstractVar v2 = new Vector("{1.0, 2.0, 3.0}");
        AbstractVar v3 = new Matrix(new double[][] {{1, 2, 3}, {4, 5, 6}});
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }
}
