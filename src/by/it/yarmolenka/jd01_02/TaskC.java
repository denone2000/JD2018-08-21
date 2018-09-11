package by.it.yarmolenka.jd01_02;

public class TaskC {

    static void step3(int[][] mas){
        int max=Integer.MAX_VALUE;
        for (int[] row : mas){
            for (int element : row){
                if (max<element)
                    max=+element;
            }
        }
    // build markers
        boolean[] delRow=new boolean[mas.length];
        boolean[] delCol=new boolean[mas[0].length];
        for (int i = 0; i <mas.length ; i++) {

        }
    }

}
