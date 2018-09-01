package by.it.bindyuk.jd01_03;

public class InOut {
    /**
     * @param line входная строка для преобразования в массив double'ов
     * @return массив double'ов
     */
    public static double[] getArray(String line) {
        String[] strVar = line.trim().split(" ");
        double[] res = new double[strVar.length];
        for (int i = 0; i < strVar.length; i++) {
            res[i] = Double.parseDouble(strVar[i]);
        }
        return res;
    }

    /**
     * @param arr одномерный массив для вывода в консоль
     */
    public static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * @param arr массив для вывода в консоль
     * @param name имя элементов
     * @param colomnCount количество колонок
     */
    public static void printArray(double[] arr, String name, int colomnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.3f ", name, i, arr[i]);
            if ((i + 1) % colomnCount == 0)
                System.out.println();
        }
        System.out.println();
    }

}
