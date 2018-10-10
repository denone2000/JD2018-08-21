package by.it.korzik.jd02.jd02_04;

import by.it.korzik.jd02.jd02_04.Var;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }
    Matrix(Matrix matrix){
        value=matrix.value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            String delimit = "";
            sb.append("{");
            for (double v1 : value[i]) {
                sb.append(delimit).append(v1);
                delimit = ", ";
            }
            if (i != value.length-1) {
                sb.append("},");
            } else {
                sb.append("}");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
