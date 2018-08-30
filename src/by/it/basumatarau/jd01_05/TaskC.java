package by.it.basumatarau.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        double[] someArr = arrayGen(5.33,9.0,20, 40);
        arrayPrintFormat(someArr, 5, "A");
        double[] someArrRearranged = arrayRearranger(someArr,3.5);
        arrayPrintFormat(someArrRearranged, 5, "B");
        System.out.println("avg value: " + avg(someArrRearranged));
    }
    private static double avg(double[] arr){
        double result=1.0;
        for (int i = 0; i < arr.length; i++) {
            result*=arr[i];
        }
        return Math.pow(result, Math.pow(arr.length, -1.0));
    }
    private static double[] arrayRearranger(double[] array, double threshold){
        int newLen = 0;
        boolean[] matcher = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>threshold) {
                newLen++;
                matcher[i]=true;
            }
        }
        double[] result = new double[newLen];
        int ptr = 0;
        for (int i = 0; i < array.length; i++) {
            if(matcher[i]) {
                result[ptr] = array[i];
                ptr++;
            }
        }
        return result;
    }
    private static void arrayPrintFormat(double[] array, int col, String name){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d] = %-6.5f   ", name, i, array[i]);
            if((i+1)%col==0) System.out.print('\n');
        }
        System.out.print('\n');
    }

    private static double[] arrayGen(double lowerLim, double upperLim, int minLenght, int maxLength){
        double[] result = new double[minLenght + (int) (Math.random()*(maxLength - minLenght + 1))];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.pow((Math.pow(Math.random()*(upperLim-lowerLim) + lowerLim,2.0)+4.5),1.0/3.0);
        }
        return result;
    }

}
