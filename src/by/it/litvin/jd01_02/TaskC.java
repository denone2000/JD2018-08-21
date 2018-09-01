package by.it.litvin.jd01_02;

public class TaskC {

    int[][] step3(int[][] mas) {
        //find max
        int max = Integer.MIN_VALUE;
        for (int[] row : mas) {
            for (int element : row) {
                if (max < element)
                    max = element;
            }
        }
        //build markers
    boolean[] delRow=new boolean[mas.length];
    boolean[] delCol=new boolean[mas[0].length];
        for (int i = 0; i <mas.length ; i++) {
            for (int j = 0; j <mas[i].length ; j++) {
                if (mas[i][j]==max){
                    delCol[j]=true;
                    delRow[i]=true;
                }
            }

            }

        //calc size result
    int rowCount=0;
        int colCount=0;
        for(boolean b : delRow){
        if (!b) colCount++;}
        int[][] res = new int[rowCount][colCount];

        //fill res
        int ir = 0;
        for (int i = 0; i <mas.length ; i++) {
            if (!delRow[i]){
                int jc=0;
                for (int j = 0; j <mas[i].length ; j++) {
                    if (!delCol[j]){
                        res[ir][jc]=mas[i][j];
                        jc++;
                    }

                }
                ir++;
            }
        }
          return res;
        }

        }