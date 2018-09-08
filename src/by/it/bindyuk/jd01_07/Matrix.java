package by.it.bindyuk.jd01_07;

public class Matrix extends AbstractVar {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        value = matrix.value;
    }

    // { { 1.0, 2.0 }, { 3.0, 4.0 } }

    public Matrix(String strMatrix) {
        String[] yards = strMatrix.split("},");
        String[] yards2 = new String[yards.length];
        for (int i = 0; i < yards2.length; i++) {
            yards2[i] = yards[i].replace('{', ' ').replace('}', ' ').trim();
        }
        value = new double[yards2.length][yards2[0].split(",").length];
        for (int i = 0; i < yards2.length; i++) {
            String[] arrayOfMatrix = yards2[i].split(",");
            for (int j = 0; j < arrayOfMatrix.length; j++) {
                value[i][j] = Double.parseDouble(arrayOfMatrix[j]);
            }
        }
    }

    @Override

    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimeter1 = "{";
        for (int i = 0; i < value.length; i++) {
            result.append(delimeter1);
            String delemeter2 = "";
            for (int j = 0; j < value[i].length; j++) {
                result.append(delemeter2).append(value[i][j]);
                delemeter2 = ", ";
            }
            delimeter1 = "}, {";
        }
        result.append("}}");
        return result.toString();
    }
}



















