package by.it.galushka.jd01_03;

public class InOut {

    /**
     * getArray преобразует строку в массив вещественных чисел;
     * @param line входная строка;
     * @return возврат массива вещественных чисел;
     */
    public static double[] getArray(String line) {
        String[] strArray = line.trim().split(" ");
        double[] res = new double[strArray.length];
        for (int i=0; i < res.length; i++) {
            res[i] = Double.parseDouble(strArray[i]);
        }
        return res;
    }

    /**
     * printArray распечатывает массив(print);
     * @param arr входной массив вещественных чисел;
     */
    public static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    /**
     * printArray распечатывает массив(printf);
     * @param arr входной массив вещественных чисел;
     * @param name параметр "имя" для printf;
     * @param columnCount количество колонок;
     */
    public static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-7.1f", name,i,arr[i]);
            if ((i+1)%columnCount == 0 || i+1==arr.length) System.out.println();
        }
    }
}
