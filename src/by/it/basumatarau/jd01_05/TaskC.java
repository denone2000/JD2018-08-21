package by.it.basumatarau.jd01_05;


public class TaskC {
    public static void main(String[] args) {
        double[] someArr = arrayGen(5.33,9.0,20, 40);
        arrayPrintFormat(someArr, 5, "A");
        double[] someArrRearranged = arrayRearranger(someArr,3.5);
        arrayPrintFormat(someArrRearranged, 5, "B");
        System.out.println("avg value: " + avg(someArrRearranged));
        someArr = arrayGen2(103, 450, 31);
        arrayPrintFormat(someArr, 5, "A");
        someArrRearranged = arrayRearranger2(someArr, 10);
        arrayPrintFormat(arraySort(someArrRearranged), 5, "B");
        drawGorgeousTableCol(someArr, "A", 5);
        drawGorgeousTableRow(someArrRearranged, "B", 10);
    }

    private static void drawGorgeousTableRow(double[] arr, String name, int row){
        StringBuilder out = new StringBuilder();
        StringBuilder[] str = new StringBuilder[row];
        for (int i = 0; i < str.length; i++) {
            str[i] = new StringBuilder();
        }
        int currentRow = 0;
        int col = (arr.length%row !=0 ? arr.length/row + 1: arr.length/row);
        int currentCol = 0;
        for (int i = 0; i < arr.length; i++) {
            str[currentRow++].append('\u2551' + String.format(" %s[% -3d]=%-4.1f ", name, i, arr[i]));

            if(currentRow!=0 && i == arr.length-1){
                for (int j = currentRow; j < row; j++) {
                    str[currentRow++].append("\u2551"+String.format("%14s", " "));
                }
            }
            if(currentRow == row) currentRow=0;
        }

        for (StringBuilder string:
                str) {
            string.append("\u2551"+"\n");
        }

        StringBuilder aux = new StringBuilder();

        for (int i = 0; i < col-1; i++) {
            if (i==0){
                aux.append(String.format('\u2554'+"%14s", ' ').replace(' ','\u2550') + '\u2566');
            }
            if (i==col-2){
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u2557' + '\n');
            }else {
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u2566');
            }
        }
        out = new StringBuilder();
        out.append(aux);
        for (StringBuilder buffer : str) {
            out.append(buffer);
        }
        String top = new String(aux);
        aux = new StringBuilder();
        for (int i = 0; i < col -1; i++) {
            if (i==0){
                aux.append(String.format('\u255A'+"%14s", ' ').replace(' ','\u2550') + '\u2569');
            }
            if (i==col-2){
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u255D' + '\n');
            }else {
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u2569');
            }
        }
        String bottom = new String(aux);
        aux = new StringBuilder();
        for (int i = 0; i < col-1; i++) {
            if (i==0){
                aux.append(String.format('\u2560'+"%14s", ' ').replace(' ','\u2550') + '\u256C');
            }
            if (i==col-2){
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u2563' + '\n');
            }else {
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u256C');
            }
        }

        for (int i = 0; i < str.length-1; i++) {
            str[i].append(aux);
        }
        out = new StringBuilder();
        out.append(top);
        for (StringBuilder StringBuilder : str) {
            out.append(StringBuilder);
        }
        out.append(bottom);
        System.out.println(out);

    }

    private static void drawGorgeousTableCol(double[] arr, String name, int col){

        StringBuilder string = new StringBuilder();
        StringBuilder aux = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            string.append('\u2551'+String.format(" %s[% -3d]=%-4.1f ", name, i, arr[i]));
            if((i+1)%col==0) {
                string.append('\u2551');
                string.append('\n');
            }else if(i==arr.length-1){
                string.append('\u2551');
                for (int j = (i+1)%col; j < col; j++) {
                    string.append(String.format("%14s", " ")+'\u2551');
                }
                string.append('\n');
            }
        }
        for (int i = 0; i < col-1; i++) {
            if (i==0){
                aux.append(String.format('\u2554'+"%14s", ' ').replace(' ','\u2550') + '\u2566');
            }
            if (i==col-2){
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u2557' + '\n');
            }else {
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u2566');
            }
        }
        aux.append(string);
        string = aux;
        aux = new StringBuilder();
        for (int i = 0; i < col-1; i++) {
            if (i==0){
                aux.append(String.format('\u255A'+"%14s", ' ').replace(' ','\u2550') + '\u2569');
            }
            if (i==col-2){
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u255D' + '\n');
            }else {
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u2569');
            }
        }
        string.append(aux);
        aux = new StringBuilder();
        for (int i = 0; i < col-1; i++) {
            if (i==0){
                aux.append(String.format('\u2560'+"%14s", ' ').replace(' ','\u2550') + '\u256C');
            }
            if (i==col-2){
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u2563' + '\n');
            }else {
                aux.append(String.format("%14s", ' ').replace(' ','\u2550') + '\u256C');
            }
        }
        String[] stringArr = string.toString().split("\n");
        string = new StringBuilder();
        for (int i = 0; i < stringArr.length; i++) {
            string.append(stringArr[i]+'\n');
            if(i!=0 && i!=stringArr.length-1&&i!=stringArr.length-2) {
                string.append(aux);
            }
        }
        System.out.println(string);
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
            System.out.printf("%s[% -3d] = %-4.1f   ", name, i, array[i]);
            if((i+1)%col==0) System.out.print('\n');
        }
        System.out.print('\n');
    }

    private static double[] arrayGen(double lowerLim, double upperLim, int minLenght, int maxLength){
        double[] result = new double[minLenght + (int) (Math.random()*(maxLength - minLenght + 1))];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.pow((Math.pow(((upperLim-lowerLim)*i/result.length + lowerLim),2.0)+4.5),1.0/3.0);
        }
        return result;
    }
    private static double[] arrayGen2(double lowerLim, double upperLim, int length){
        double[] result = new double[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int)((upperLim-lowerLim)*Math.random()+ lowerLim + 1);
        }
        return result;
    }
    private static double[] arrayRearranger2(double[] array, int ratio){
        int newLen = 0;
        boolean[] matcher = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>i*ratio) {
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
    private static double[] arraySort(double[] arr){
        return mergeSort(arr, 0, arr.length-1);
    }

    private static double[] mergeSort(double[] arr, int l, int r) {
        while(r>l){
            double [] left = mergeSort(arr, l, (l+r)/2);
            double [] right = mergeSort(arr, ((l+r)/2) +1, r);
            return merge(left, right);
        }
        return new double[]{arr[l]};
    }

    private static double[] merge(double[] left, double[] right) {
        int ptrL = 0, ptrR = 0, ptrResult = 0;
        double[] result = new double[left.length+right.length];
        while (ptrL<left.length && ptrR<right.length){
            result[ptrResult++]= left[ptrL]>right[ptrR] ? right[ptrR++] : left[ptrL++];
        }
        while(ptrR!=right.length){
           result[ptrResult++] = right[ptrR++];
        }
        while(ptrL!=left.length){
            result[ptrResult++] = left[ptrL++];
        }
        return result;
    }

}
