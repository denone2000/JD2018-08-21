package by.it.basumatarau.jd01_05;
import java.math.*;

public class TaskA {
    public static void main(String[] args) {
        System.out.println(calcExpr(756.13,0.3));
        System.out.println(calcExpr2(1.21,0.371));
        calcExpr3(12.1, -5.0, 12.0, 3.75);
    }

    private static double[] calcExpr3(double x, double aLowerLim, double aUpperLim, double deltaA) {
    double[] result = new double[(int)((aUpperLim-aLowerLim)/deltaA)+1];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.pow(Math.E, x*(aLowerLim+i*deltaA))-3.45*(aLowerLim+i*deltaA);
            System.out.printf("При а=%-4.2f результат=%-8.4f %n", aLowerLim+deltaA*i, result[i]);
        }
    return result;
    }

    static double calcExpr(double a, double x){
        double result = Math.cos(Math.pow((Math.pow(x, 2.0) + Math.PI/6.0), 5.0));
        result-= Math.pow(x*Math.pow(a, 3.0), 0.5);
        result-= Math.log(Math.abs((a - 1.12*x)/4.0));
        return result;
    }
    static double calcExpr2(double a, double b){
        double result= Math.tan(Math.pow(a+b,2.0));
        result-= Math.pow(a + 1.5, 1.0/3.0);
        result+= Math.pow(b, 5.0)*a;
        result-= b/Math.log(Math.pow(a, 2.0));
        return result;
    }

}
