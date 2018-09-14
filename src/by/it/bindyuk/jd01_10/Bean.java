package by.it.bindyuk.jd01_10;

public class Bean {
    @Param(a = 4, b = 2)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 42, b = 420)
    static double max(int a, int b) {
        return (a > b) ? a : b;
    }

    double min(int a, int b) {
        return (a < b) ? a : b;
    }

    @Param(a = 55, b = 42)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
