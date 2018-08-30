package basumatarau.jd01_04;
import by.it.basumatarau.jd01_03.InOut;

public class TaskC {
    public static void main(String[] args) {
    buildOneDimArray("1 2 7 3 -23 3 0 -2 1");
    }

    public static void buildOneDimArray(String line){
        double[] doubleArr = InOut.getArray(line);
        double firstDoubleItem = doubleArr[0];
        double lastDoubleItem = doubleArr[doubleArr.length -1];

        InOut.printArray(doubleArr, "V", 5);
        System.out.print('\n');
        mergeSort(doubleArr);
        InOut.printArray(doubleArr, "V", 4);

        System.out.println("first element=" + binarySearch(doubleArr, firstDoubleItem));
        System.out.println("last element=" + binarySearch(doubleArr, lastDoubleItem));
    }
    private static int binarySearch(double[] array, double vale){
        return binSearch(array, vale, 0, array.length -1);
    }
    private static int binSearch(double[] array, double value, int l, int r){
        if (value > array[r] || value < array[l]) return -1;
        while (r > l){
            if (value > array[(l+r)/2]){
                return binSearch(array, value, (l+r)/2 +1, r);
            }else return binSearch(array, value, l, (l+r)/2);
        }
        if (l==r && value == array[l]) return l;
        return -1;
    }

    private static void mergeSort(double[] array){
        double[] result = mergeSort(array, (int) 0,array.length -1);
        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }

    private static double[] mergeSort(double[] subArray, int l, int r){
        if (l<r){
            double[] left = mergeSort(subArray, l, (int) (l+r)/2);
            double[] right = mergeSort(subArray, (int) (l+r)/2 + 1, r);
            double[] result = merge(left, right);
            return result;
        } else return new double[] {subArray[l]};
    }

    private static double[] merge(double[] array1, double[] array2){
        int ptr1 = 0,
            ptr2 = 0,
            ptrRes = 0;
        double[] result = new double[array1.length + array2.length];
        while (ptr1 < array1.length && ptr2 < array2.length){
            result[ptrRes++] = array1[ptr1]>array2[ptr2] ? array2[ptr2++]: array1[ptr1++];
        }
        if (array2.length != ptr2){
            for (int i = ptrRes; i < array1.length + array2.length; i++) {
                result[i] = array2[ptr2++];
            }
        }
        else if (array1.length != ptr1){
            for (int i = ptrRes; i < array1.length + array2.length; i++) {
                result[i] = array1[ptr1++];
            }
        }
        return result;
    }
}
