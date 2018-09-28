package by.it.kuzmich.jd01.jd01_10;

public class Bean {
    @Param(a = 2, b = 4)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 5, b = 7)
    static double min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    @Param(a = 2, b = 4)
    double max(int a, int b) {
        return a > b ? a : b;
    }

    double avg(int a, int b) {
        return ((double) (a + b) / 2);
    }

}
