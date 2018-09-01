package by.it.artemliashkov.jd01_03;

import java.util.Random;
import java.util.Scanner;

/**
 * Класс для запуска исходных тестов
 */
public class Runner {
    public static  void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        //String line="3 4 5 6 7 8 9";
        double array[]=InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"A",4);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        String amount_n=scanner.nextLine();
        String amount_m=scanner.nextLine();
        Random r = new Random();
        if((Integer.parseInt(amount_n)>=2)&&(Integer.parseInt(amount_m)>=1)||(Integer.parseInt(amount_m)>=2)&&(Integer.parseInt(amount_n)>=1))
        {
            int k=Integer.parseInt(amount_n);
            int l=Integer.parseInt(amount_m);
            double[][] array2 = new double[k][l];
            InOut.matrix(k,l);
            int max=k;
            if(l>=k)
                max=l;
            double[] array3 = new double[max];
            System.out.println();
            InOut.vector(max);
            System.out.println();
            Helper.mul(array2,array3);
            System.out.println();
            double[][] array4 = new double[l][k];
            InOut.matrix(l,k);
            System.out.println();
            Helper.mul(array2,array4);
        }
    }
}
