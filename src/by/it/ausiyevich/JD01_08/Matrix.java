package by.it.ausiyevich.JD01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];

        System.arraycopy(value, 0, this.value, 0, value.length);
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
        /*
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                this.value[i][j]=value[i][j];
            }
        }
        */
    }

    public Matrix(Matrix anotherMatrix) {
        this.value = new double[anotherMatrix.value.length][anotherMatrix.value[0].length];
        System.arraycopy(anotherMatrix.value, 0, this.value, 0, anotherMatrix.value.length);
        for (int i = 0; i < anotherMatrix.value[0].length; i++) {
            System.arraycopy(anotherMatrix.value[i], 0, this.value[i], 0, anotherMatrix.value.length);
        }
        /*
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                    this.value[i][j]=anotherMatrix.value[i][j];
            }
        }
        */
    }

    public Matrix(String strMatrix) {
        Pattern NumLine = Pattern.compile("(\\{[^{}]+\\})");
        Matcher NumLineMatcher = NumLine.matcher(strMatrix);
        int lines = 0;
        while (NumLineMatcher.find()) lines++;
        String[][] matrLines = new String[lines][];
        NumLineMatcher.reset(strMatrix);
        for (int i = 0; i < lines && NumLineMatcher.find(); i++) {
            matrLines[i] = NumLineMatcher.group().replace('{', ' ').replace('}', ' ').trim().split(",\\s*");
        }
        double[][] result = new double[matrLines.length][matrLines[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = Double.parseDouble(matrLines[i][j]);
            }
        }
        this.value = result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String delimiterNum;
        String delimiterArr = "";
        result.append("{");
        for (double[] row : value) {
            result.append(delimiterArr);
            delimiterNum = "";
            result.append("{");
            for (double num : row) {
                result.append(delimiterNum).append(Double.toString(num));
                delimiterNum = ", ";
            }
            result.append("}");
            delimiterArr = ", ";
        }
        result.append("}");
        return result.toString();
    }
}
