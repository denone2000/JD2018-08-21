package by.it.bindyuk.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] addScalar = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < value.length; i++) {
                addScalar[i] = Arrays.copyOf(value[i], value[i].length);
            }

            for (int i = 0; i < addScalar.length; i++) {
                for (int j = 0; j < addScalar[i].length; j++) {
                    addScalar[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(addScalar);

        } else if (other instanceof Matrix) {
            double[][] addMatrix = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    addMatrix[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(addMatrix);
        } else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix) {
            double[][] subMatrix = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    subMatrix[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(subMatrix);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            double[] mulVector = new double[((Vector) other).getValue().length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    mulVector[i] += this.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(mulVector);

        } else return null;
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        double[][] copyOfMas = Arrays.copyOf(this.value, this.value.length);
        StringBuilder result = new StringBuilder("{");
        String delimeter1 = "{";
        for (int i = 0; i < copyOfMas.length; i++) {
            result.append(delimeter1);
            String delemeter2 = "";
            for (int j = 0; j < copyOfMas[i].length; j++) {
                result.append(delemeter2).append(copyOfMas[i][j]);
                delemeter2 = ", ";
            }
            delimeter1 = "}, {";
        }
        result.append("}}");
        return result.toString();
    }
}
