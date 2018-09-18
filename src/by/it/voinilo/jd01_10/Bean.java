package by.it.voinilo.jd01_10;

public class Bean {
@Param(a=3, b=4)
    double sum (int a, int b){return  a+b;}
    @Param(a=30, b=4)
    double min (int a, int b){return  a<b ? a:b;}
    @Param(a=32, b=4)
    static double max (int a, int b){return  a>b ? a:b;}

    static double avg (int a, int b){return  (a+b)/2.0;}

}
