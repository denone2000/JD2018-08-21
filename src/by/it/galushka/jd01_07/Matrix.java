package by.it.galushka.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends AbstractVar {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String[] rowsMatrix = strMatrix.split("\\}\\,\\s?\\{");
        int lengthRows = 0;
        int lengthColomns = rowsMatrix.length;
        for (String str : rowsMatrix) {
            StringBuilder sb = new StringBuilder(str);
            Pattern compile = Pattern.compile("[0-9]+");
            Matcher matcher = compile.matcher(str);
            while (matcher.find()) {
                lengthRows++;
            }
            break;
        }
        this.value = new double[lengthColomns][lengthRows];
        for (int i = 0; i < rowsMatrix.length; i++) {
            double[] colomnsMatrix = {};
            StringBuilder sb = new StringBuilder(rowsMatrix[i]);
            Pattern compile = Pattern.compile("[0-9]+");
            Matcher matcher = compile.matcher(sb);
            while (matcher.find()) {
                String group = matcher.group();
                double convertToDouble = Double.parseDouble(group);
                colomnsMatrix = Arrays.copyOf(colomnsMatrix, colomnsMatrix.length+1);
                colomnsMatrix[colomnsMatrix.length-1] = convertToDouble;
            }
            for (int j = 0; j < colomnsMatrix.length; j++) {
                this.value[i][j] = colomnsMatrix[j];
                System.out.print(colomnsMatrix[j] + " ");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ { ");
        String delimiter = ", ";
        for (int i = 0; i < this.value.length-1; i++) {
            for (int j = 0; j < this.value[0].length-1; j++) {
                sb.append(this.value[i][j] + delimiter);
            }
            sb.append(this.value[i][this.value[0].length-1]).append(" }, { ");
        }
        for (int j = 0; j < this.value[0].length-1; j++) {
            sb.append(this.value[this.value.length-1][j] + delimiter);
        }
        sb.append(this.value[this.value.length-1][this.value[0].length-1]).append(" } }");
        return sb.toString();
    }
}
