package by.it.artemliashkov.jd01_04;


import by.it.artemliashkov.jd01_03.InOut;

import java.util.Scanner;

public class TaskC {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double array[] = InOut.getArray(line);
        mergeSort(array);
    }


    static void mergeSort(double[] A) {
        if(A.length <2) return; //do not need to sort
        int mid = A.length/2;
        double left[] = new double[mid];
        double right[] = new double[A.length-mid];
        for(int i=0; i<mid; i++){
            left[i] = A[i];
        }
        for(int i=0; i<A.length-mid; i++){
            right[i] = A[mid+i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, A);
    }

    private static void merge(double[] a, double[] b, double[] all){
        int i=0, j=0, k=0;
        while(i<a.length && j<b.length){
            if(a[i] < b[j]){
                all[k] = a[i];
                i++;
            }else{
                all[k] = b[j];
                j++;
            }
            k++;
        }
        while(i<a.length){
            all[k++] = a[i++];
        }
        while(j<b.length){
            all[k++] = b[j++];
        }
    }




    /*static int  binarySearch(double[] array, double value) {
        int first=0;
        int last=array.length-1;
        int middle=(first+last)/2;
        while (first<=last)
        {
            if(array[middle]<=value)
            {
                first=middle+1;
            }
            else if(array[middle] ==value)
            {
                return 1;
            }
            else
            {
                last=middle-1;
            }
            middle=(first+last)/2;
        }
        return 0;
    }*/
}
