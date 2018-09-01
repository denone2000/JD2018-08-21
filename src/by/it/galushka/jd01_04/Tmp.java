package by.it.galushka.jd01_04;

import by.it.galushka.jd01_03.InOut;

import java.util.Scanner;

public class Tmp {
    public static void main(String[] args) {
        double[] array = {8,20,99,54,9,45,14,3,9,7,20,63,4,7,1,32,4,46,74};
    }

    /*static void mergeSort(double[] array) {
        int random = 10;
        System.out.println(random);
        System.out.println(array[random]);
        for (int i = 0; i < random; i++) {
            if (array[i] > array[random]){
                double tmp = array[i];
                array[i] = array[random-1];
                array[random-1] = tmp;
                tmp = array[random-1];
                array[random-1] = array[random];
                array[random] = tmp;
                i--;
                random--;
            }
            else if (array[i] == array[random]) {
                boolean bool;
                for (int j = i; j < random; j++) {
                    if (array[j] == array[j+1])
                        bool = true;
                    else {
                        bool = false;
                        break;
                    }
                }
                if (bool = false) {
                    double tmp = array[random - 1];
                    array[random - 1] = array[i];
                    array[i] = tmp;
                    i--;
                }
            }
        }
        /*random = 15;
        for (int i = random+1; i < array.length-1; i++) {
            if (array[i] > array[random]){
                double tmp = array[i];
                array[i] = array[random-1];
                array[random-1] = tmp;
                tmp = array[random-1];
                array[random-1] = array[random];
                array[random] = tmp;
                i--;
                random--;
            }
        }
        for (double element : array) {
            System.out.print(element + " ");
        }
    }*/
}

