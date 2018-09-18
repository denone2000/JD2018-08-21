package by.it.galushka.jd01_10;

public class Bean {

    @Param(a = 3, b = 8)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 4, b = 3)
    static double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 7, b = 11)
    double min(int a, int b) {
        return a < b ? a : b;
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
