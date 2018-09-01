package by.it.nesterovich.jd01_03;

/**
 * Класс для задания уровня А;
 *
 * @author Нестерович;
 * @version 1.0;
 */
public class InOut {

    /**
     * Метод для преобразования строки в массив из чисел;
     *
     * @param line- строка с данными;
     * @return double[] res - массив сформированный из String line;
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
     * Метод для вывода одномерного массива на консоль;
     *
     * @param arr - одномерный массив типа double;
     */
    public static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Метод для вывода одномерного массива на консоль с префиксом и заданным количеством столбцов;
     *
     * @param arr         - одномерный массив типа double;
     * @param name        - префикс для эллемента массива;
     * @param columnCount - число столбцов выводимых на консоль;
     */
    public static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.3f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arr.length) {
                System.out.println();
            }
        }
    }
}
