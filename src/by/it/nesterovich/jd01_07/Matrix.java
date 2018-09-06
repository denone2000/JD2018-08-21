package by.it.nesterovich.jd01_07;

import java.util.Arrays;

public class Matrix extends AbstractVar {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.substring(1, strMatrix.length());
        strMatrix = strMatrix.substring(0, strMatrix.length() - 1);
        String[] arrayString = strMatrix.split("},");
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = arrayString[i].replace("{", "").replace("}", "");
        }
        String[] numberElementInRow = arrayString[0].split(",");
        value = new double[arrayString.length][numberElementInRow.length];
        for (int i = 0; i < arrayString.length; i++) {
            String[] arrayMatrix = arrayString[i].split(",");
            for (int j = 0; j < arrayMatrix.length; j++) {
                value[i][j] = Double.parseDouble(arrayMatrix[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiterI = "{";
        for (int i = 0; i < value.length; i++) {
            sb.append(delimiterI);
            String delimiterJ = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiterJ).append(value[i][j]);
                delimiterJ = ", ";
            }
            delimiterI = "}, {";
        }
        sb.append("}}");
        return sb.toString();
    }
}
