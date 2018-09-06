package by.it.litvin.jd01_08;

class Matrix extends Var {
    private double[][] value;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                result.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            delimiter = "},{";
        }
        result.append("}}");
        return result.toString();
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }


    public Matrix(String strMatrix) {

        strMatrix = strMatrix.replace('{', ' ').replace('}', ' ').trim();
        String[] strArray = strMatrix.split(",\\s*");
        value = new double[2][2];
        int m = 0;
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                value[i][j] = Double.parseDouble(strArray[m++]);


            }
        }
    }
}


