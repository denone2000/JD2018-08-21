package by.it.kisielev.jd01_04;

import java.util.Arrays;

public class Helper {

    static  double  findMin1 (double[ ] arr){
        double min=Integer.MAX_VALUE;
        double[] tmp =Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);
        return tmp[0];
    }

    static double findMin (double[ ] arr){
        double[] tmp =Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);
        return tmp[tmp.length-1];
    }
    static void sort (double[ ] arr){
        for (int last = arr.length-1; last > 0; last--) {
            for (int j = 0; j < last ; j++) {
                if (arr[j]>arr[j+1]){
                    double tmp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }
}
