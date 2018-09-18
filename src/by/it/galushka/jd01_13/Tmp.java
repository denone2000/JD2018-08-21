package by.it.galushka.jd01_13;

public class Tmp {
    public static void main(String[] args) {
        try {
            double a = -2;
            double res = Math.sqrt(a);
            String result = String.valueOf(res);
//            System.out.println("double: " + res);
//            System.out.println("String: " + result);
            if (result.equalsIgnoreCase("nan")) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
//            String name = e.getClass().getName();
//            System.out.println(name);
        }
    }
}
