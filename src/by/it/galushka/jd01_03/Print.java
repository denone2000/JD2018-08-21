package by.it.galushka.jd01_03;

public class Print {

    /**
     * printRes распечатывает матрицу(print);
     * @param res входная матрица;
     */
    static void printRes(double[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[i][j]+" ");
            }
            if((i+1)%res.length == 0)
                System.out.println();
        }
    }
}

