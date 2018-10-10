package by.it.korolchuk.jd02_04;

import java.util.Arrays;

public class Matrix extends Var {

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
            delimiter = "}, {";
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

    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[value.length][value.length];
            //double[][] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    result[i][j] = value[i][j];
                }
            }
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += scalar;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix) {
            double[][] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else
            return super.add(other);

    }

    public Var sub(Var other) {
        if (other instanceof Scalar) {
            //double[][] result = new double[value.length][value.length];
            double[][] result = Arrays.copyOf(value, value.length);
           /* for (int i = 0; i < value.length ; i++) {
                for (int j = 0; j < value.length; j++) {
                    result[i][j] = value[i][j];
                }
            }*/
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] -= scalar;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix) {
            double[][] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] -= ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else
            return super.add(other);

    }

    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[value.length][value.length];
            //double[][] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    result[i][j] = value[i][j];
                }
            }
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= scalar;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix) {
            double[][] result = Arrays.copyOf(value, value.length);
            double[][] sum = new double[value.length][((Matrix) other).value.length];
            for (int i = 0; i < ((Matrix) other).value.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    for (int k = 0; k < result.length; k++) {
                        sum[i][j] += result[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(sum);
        } else if (other instanceof Vector) {
            double[][] result = Arrays.copyOf(value, value.length);
            double[] vector = ((Vector) other).getValue();
            for (int j = 0; j < result.length; j++) {
                for (int i = 0; i < result.length; i++) {
                    result[i][j] += result[i][j] * vector[i];
                }
            }
            return new Matrix(result);
        } else
            return super.add(other);

    }


    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replace('{', ' ').replace('}', ' ').trim();
        String[] strArray = strMatrix.split(",\\s*");
        value = new double[2][2];
        int counter = 0;
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                value[i][j] = Double.parseDouble(strArray[counter++]);
            }
        }
    }


}


