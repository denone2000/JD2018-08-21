package by.it.nesterovich.jd01_03;

import java.util.Scanner;

/**
 * Класс для задания уровня С;
 *
 * @author Нестерович;
 * @version 1.0;
 */
public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("---ПРОВЕРКА ВВОДА И ВЫВОДА ОДНОМЕРНЫХ МАССИВОВ---");
        System.out.println();
        System.out.println("Введите числа для заполнения одномерного массива");

        //ПРОВЕРКА ВВОДА И ВЫВОДА ОДНОМЕРНЫХ МАССИВОВ
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "A", 4);

        System.out.println();
        System.out.println();
        System.out.println("---ПРОВЕРКА СОРТИРОВКИ И ПОИСКА МАКСИМУМА/МИНИМУМА В ОДНОМЕРНОМ МАССИВЕ---");
        System.out.println();

        //ПРОВЕРКА СОРТИРОВКИ И ПОИСКА МАКСИМУМА/МИНИМУМА В ОДНОМЕРНОМ МАССИВЕ
        Helper.sort(array);
        System.out.println("Ниже приведён отсортированный одномерный массив");
        InOut.printArray(array);
        System.out.println("Максимум равен: " + Helper.findMax(array));
        System.out.println("Минимум равен: " + Helper.findMin(array));

        System.out.println();
        System.out.println();
        System.out.println("---ПРОВЕРКА ОПЕРАЦИИ МАТРИЧНОГО УМНОЖЕНИЯ---");
        System.out.println();

        //ПРОВЕРКА ОПЕРАЦИИ МАТРИЧНОГО УМНОЖЕНИЯ
        System.out.print("Введите высоту первой матрицы: ");
        int heightMatrix1 = scanner.nextInt();
        System.out.print("Введите длину первой матрицы: ");
        int lengthMatrix1 = scanner.nextInt();
        System.out.print("Введите длину второй матрицы: ");
        int lengthMatrix2 = scanner.nextInt();

        double[][] matrix1 = new double[heightMatrix1][lengthMatrix1];
        double[][] matrix2 = new double[lengthMatrix1][lengthMatrix2];

        //Заполнение матрица1 случайными числами и вывод на консоль
        System.out.println();
        System.out.println("Матрица1:");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = Math.random();
                System.out.printf(matrix1[i][j] + "  ");
            }
            System.out.println();
        }

        //Заполнение матрица2 случайными числами и вывод на консоль
        System.out.println();
        System.out.println("Матрица2:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = Math.random();
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        //Вывод на консоль результата умножения матрица1 на матрица2
        System.out.println();
        System.out.println("Результат умножения матрица1 на матрица2:");
        double[][] resultMatrix = Helper.mul(matrix1, matrix2);
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + "  ");
            }
            System.out.println();
        }
    }


}
