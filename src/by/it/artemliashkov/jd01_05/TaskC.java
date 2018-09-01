package by.it.artemliashkov.jd01_05;

import java.util.ArrayList;
import java.util.Scanner;



public class TaskC {
    public static void main(String[] args) {
        int n=arrayLength();
        double[] array = new double[n];//Тесты не хотят проходить проверку на ввод диапазона массива
        //double[] array = new double[25];
        fillArray(array);
        printArray(array, "M", 5);
        System.out.println();
        double[] arrayB = newArray(array);
        printArray(arrayB, "M", 5);
        double geometricMean = geometricMean(arrayB);
        System.out.println("Среднее геометрическое = " + geometricMean);
    }

    public static int arrayLength()
    {
        Scanner scanner=new Scanner(System.in);
        Integer n=scanner.nextInt();
        boolean isTrue=true;
        boolean isFirstIn=true;
        do {
            if(!isFirstIn)
                n=scanner.nextInt();
            if((n>=20)&&(n<=40))
                isTrue = false;
            isFirstIn=false;
        }while (isTrue);
        return n;
    }

    public static void fillArray(double[] array) {
        double x = 5.33;
        for (int i = 0; i < array.length; i++) {
            double z = Math.cbrt(Math.pow(x, 2) + 4.5);
            x =x+((9 - 5.33) / array.length);
            array[i] = z;
        }
    }

    private static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% 3d]=%-10.5f", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == array.length) {
                System.out.println();
            }
        }
    }

    public static double[] newArray(double[] array) {

        double newArray[]=new double[array.length];
        int amountElements=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                newArray[amountElements]=array[i];
                amountElements++;
            }
        }
        double newArray2[]=new double[amountElements];
        for (int i = 0; i < amountElements; i++) {
            newArray2[i]=newArray[i];
        }
        return newArray2;
    }

    public static double geometricMean(double[] array) {

        double resultMultiplication = 1;
        for (double element : array) {
            resultMultiplication =resultMultiplication* element;
        }
        double power = (double) 1 / array.length;

        return Math.pow(resultMultiplication, power);
    }


}
