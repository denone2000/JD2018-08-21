package by.it.akhmelev.jd01_10;

public class Bean {

    @Param(a = 3, b = 4)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 1, b = 3)
    static double min(int a, int b) {
        if (a < b) return a;
        else return b;
    }

    @Param(a = 30, b = 40)
    double max(int a, int b) {
        return a > b ? a : b;
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
