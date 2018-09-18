package by.it.nesterovich.jd01_10;

public class Bean {

    @Param(a = 3, b = 8)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 10, b = 8)
    static double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 3, b = 14)
    double min(int a, int b) {
        return a < b ? a : b;
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
