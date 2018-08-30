package by.it.bindyuk.jd01_03;

public class Testtest {
    public static void main(String[] args) {
        System.out.print("Happy New");
        System.out.print(" ");
        System.out.println("Year");
    }

    static double[] getArray1(String line) {
        String[] strVars = line.trim().split(" ");
        double[] str = new double[strVars.length];
        for (int i = 0; i < strVars.length; i++) {
            str[i] = Double.parseDouble(strVars[i]);
        }
        return str;
    }

    static void printArray1(double[] arr1) {
        for (double element1 : arr1) {
            System.out.print(element1 + " ");
        }
        System.out.println();
    }

    static void printArray1(double[ ] arr1, String name, int columnCount1){
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("%s[% -3d]=%-10.3f", name, i, arr1[i]);
            if ((i+1)%columnCount1==0) {
                System.out.println();
            }
        }
        System.out.println();
        }
    }




