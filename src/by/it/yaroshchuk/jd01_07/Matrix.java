package by.it.yaroshchuk.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends  AbstractVar {

    private double value [][];

    Matrix (Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix (double[][] value){
        this.value = value;
    }

    Matrix (String str){
        int occurrencesCount = str.length() - str.replace("}","").length() - 1;
        Pattern pattern = Pattern.compile("([0-9]*[.])?[0-9]+");
        StringBuilder sb = new StringBuilder();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            sb.append(matcher.group());
            sb.append(" ");
        }
        String[] strValue =  sb.toString().split(" ");
        int colCount = strValue.length / occurrencesCount;
        value = new double[occurrencesCount][colCount];
        for (int i = 0, k = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++, k++) {
                value[i][j] = Double.parseDouble(strValue[k]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter ="";
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                if(j + 1 < value[0].length)
                    sb.append(", ");
            }
            sb.append("}");
            if(i + 1 <  value.length)
                sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
