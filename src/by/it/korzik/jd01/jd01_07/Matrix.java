package by.it.korzik.jd01.jd01_07;

public class Matrix extends AbstractVar {
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
        String result = sb.toString();
        return result;
    }
}
