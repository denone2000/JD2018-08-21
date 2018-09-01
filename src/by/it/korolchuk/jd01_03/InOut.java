package by.it.korolchuk.jd01_03;



public class InOut {
    /**
     * Get array INT from String
     * @param line - incoming string
     * @return res - array INT[]
     */
    public static double[ ] getArray(String line) {
        //1 2 3 4 5
        String[] strVar = line.trim().split(" ");

        double[] res = new double[strVar.length];
        for (int i = 0; i < strVar.length; i++) {
            res[i] = Double.parseDouble(strVar[i]);
        }
        return res;
    }
    /**
     * Print array DOUBLE
     * @param arr - one-dimensional array
     */
   public static void printArray(double[ ] arr) {

        for (double element : arr) {
            System.out.println(element + " ");
        }
        System.out.println();
        }

    /**
     * Formatted print for array DOUBLE
     * @param arr - one-dimensional array
     * @param name - array's name
     * @param columnCount - number of columns for print
     */
    public static void printArray(double[ ] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.3f ", name, i, arr[i]);
            if ((i+1) % columnCount == 0)
            System.out.println();
        }
        System.out.println();
        }


    }

