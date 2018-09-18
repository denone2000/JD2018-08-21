package by.it.basumatarau.jd01_10;

public class Bean {
    //@Param(a=3, b=4)
    public static double sum(int a, int b){
        return (double)(a+b);
    }
    @Param(a=1, b=3)
    public static double min(int a, int c){return (double)(a<c? a:c);}
    @Param(a=30, b=40)
    public double max(int a, int b){
        return (double)(a>b? a:b);
    }
    @Param(a=8, b=5)
    public double avg(int a, int b){
        return (double)(a+b)/2;
    }

}
