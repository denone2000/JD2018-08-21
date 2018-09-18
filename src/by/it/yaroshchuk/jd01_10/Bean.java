package by.it.yaroshchuk.jd01_10;

public class Bean {
    @Param(a = 2, b = 5)
    public static double sum(int a, int b){
        return a + b;
    }

    @Param(a = 2, b = 5)
    public static double max(int a, int b){
        return a > b ? a:b;
    }

    @Param(a = 2, b = 3)
    public double min(int a, int b){
        return a < b ? a:b;
    }

    public double avg(int a, int b){
        return (a + b)/2.0;
    }
}
