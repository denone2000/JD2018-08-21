package by.it.bindyuk.jd01_07;

public class Matrix extends AbstractVar {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        value = matrix.value;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replace('{', ' ').replace('}', ' ').trim();
        String[] strMatrix12 = strMatrix.split(",\\s*");
        String[] strMatrix1 = {strMatrix12[0], strMatrix12[1]};
        String[] strMatrix2 = {strMatrix12[2], strMatrix12[3]};
        value = new double[strMatrix1.length][strMatrix2.length];
        for (int i = 0; i < strMatrix1.length; i++) {
            for (int j = 0; j < strMatrix2.length; j++) {
                if (i == 0) {
                    value[i][j] = Double.parseDouble(strMatrix1[j]);
                }
                if (i == 1) {
                    value[i][j] = Double.parseDouble(strMatrix2[j]);
                }
            }
        }
    }


    @Override

    public String toString() {
        StringBuilder result = new StringBuilder("{{");
        String delimeter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                if (i == 0) {
                    result.append(delimeter).append(value[i][j]);
                    delimeter = ", ";
                    if (j == 1) {
                        result.append("}, {");
                        delimeter = "";
                    }
                }
                if (i == 1) {
                    result.append(delimeter).append(value[i][j]);
                    delimeter = ", ";
                    if (j == 1) {
                        result.append("}}");
                    }
                }
            }
        }
        return result.toString();
    }
}
