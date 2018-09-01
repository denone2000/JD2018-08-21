package by.it.artemliashkov.jd01_03;

import java.util.Arrays;

/**
 * Класс для работы с массивами
 */
public class Helper {
    /**
     * Поиск минимуума
     * @param arr Исходный массив
     * @return Минимуум
     */
    public static double findMin(double[ ] arr)
    {
        double min= arr[0];
        for (double elem : arr) {
            if (min > elem)
                min = elem;
        }
        System.out.println(min);
        return min;

    }
    /**
     * Поиск максимуума
     * @param arr Исходный массив
     * @return Максиммум
    */
    public static double findMax(double[ ] arr)
    {
        double max= arr[0];
        for (double elem : arr) {
            if (max < elem)
                max = elem;
        }
        System.out.println(max);
        return max;

    }
    /**
     * Сортировка массива
     * @param arr Исходный массив
     */
    public static void sort(double[ ] arr)
    {
        for (int last = arr.length-1; last>0;last--) {
            for (int j = 0; j < last; j++) {
                if(arr[j]>arr[j+1]){
                    double tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }

            }
        }
    }

    public static void mergeSort(double[] A) {
        if (A.length > 1) {
            int q = A.length/2;

//changed range of leftArray from 0-to-q to 0-to-(q-1)
            double[] leftArray = Arrays.copyOfRange(A, 0, q-1);
//changed range of rightArray from q-to-A.length to q-to-(A.length-1)
            double[] rightArray = Arrays.copyOfRange(A,q,A.length-1);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(A,leftArray,rightArray);
        }
    }

    public static void merge(double[] a, double[] l, double[] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        //return a;

    }




    /**
     * Умножение матрицы на вектор
     * @param matrix Исходная матрица
     * @param vector Исходный вектор
     * @return Результат умножения
     */
    public static double[ ] mul(double[ ][ ] matrix, double[ ] vector)
    {
        double[] mul = new double[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <vector.length ; j++) {
                mul[i]=mul[i]+matrix[i][j]*vector[j];
            }
        }
        return mul;
    }
    /**
     * Умножение матрицы на матрицу
     * @param matrixLeft Исходная матрица 1
     * @param matrixRight Исходная матрица 2
     * @return Результат умножения
     */
    public static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight)
    {
        double[][] mul = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i <matrixLeft.length ; i++) {
            for (int j = 0; j <matrixRight[0].length ; j++) {
                for (int k = 0; k <matrixRight.length ; k++) {
                    mul[i][j]=mul[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return mul;
    }
}
