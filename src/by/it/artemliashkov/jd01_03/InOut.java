package by.it.artemliashkov.jd01_03;
/**
 * Класс для отображения массивов и векторов
 */
public class InOut {

    /**
     * Метод преобразования строки в массив
     * @param Line Исходная строка
     * @return Результат преобразования
     */
    public static double[] getArray(String Line)
    {
        String[] strVar=Line.trim().split(" ");
        double[] res=new double [strVar.length];
        for (int i = 0; i < strVar.length; i++) {
            res[i]=Double.parseDouble(strVar[i]);
        }
        return res;
    }
    /**
     * Метод вывода матрицы
     * @param k Число столбцов
     * @param l Число строк
     * @return результат вывода
     */
    public static double[][] matrix(int k,int l)
    {
        double[][] matrix=new double [k][l];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                matrix[i][j] = (int) (Math.random()*10);
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        return matrix;
    }
    /**
     * Метод вывода вектора
     * @param k Число столбцов
     * @return результат вывода
     */
    public static double[] vector(int k)
    {
        double[] vector=new double [k];
        for (int i = 0; i <k ; i++) {
            vector[i] = (int) (Math.random()*10);
            System.out.print(vector[i]+" ");
        }
        return vector;
    }
    /**
     * Метод вывода массива
     * @param arr Исходный массив
     */
    public static void printArray(double[ ] arr)
    {
        for (double elem : arr) {
            System.out.println(elem+" ");
        }
    }
    public static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.3f",name,i,arr[i]);
            if((i+1)%columnCount==0)
            {
                System.out.println();
            }
        }
        System.out.println();
    }



}
