package by.it.ausiyevich.jd01_04;

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (min > element) min = element;
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (max < element) max = element;
        }
        return max;
    }

    static void sort(double[] arr) {
        for (int last = arr.length - 1; last > 0; last--) {
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j + 1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
