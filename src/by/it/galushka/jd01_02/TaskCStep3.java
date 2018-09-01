package by.it.galushka.jd01_02;

public class TaskCStep3 {
    public static void main(String[] args) {
        int[][] mas = {{1,2,3,4},{1,3,2,10},{1,2,3,4},{1,10,2,3}};
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                System.out.printf("%3d",mas[i][j]);
                if((j+1)%mas.length == 0)
                    System.out.println();
            }
        }
        System.out.println();
        int max = findMax(mas);
        step3(max, mas);

    }

    static int findMax(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > max) max = mas[i][j];
             }
        }
        System.out.println("Максимальное значение: "+max);
        System.out.println();
        return max;
    }

    static void step3(int max, int[][] mas) {
        int[][] matrix;
        int s = 1;
        //for (;;) {
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    if (mas[i][j] == max) {
                        int row = i;
                        int col = j;
                        int[][] m = new int[mas.length-s][mas.length-s];
                        s++;
                        for (int k = 0; k < mas.length; k++) {
                            if (k == row) continue;
                            for (int t = 0; t < mas.length; t++) {
                                if (t == col) continue;
                                m [k][t] = mas [k][t];
                            }
                        }
                        matrix = new int[m.length][m.length];
                        for (int i1 = 0; i1 < m.length; i1++) {
                            for (int i2 = 0; i2 < m.length; i2++) {
                                matrix[i1][i2] = m[i1][i2];
                            }
                        }
                    }
                    else break;
                }
            }

        }
    }
