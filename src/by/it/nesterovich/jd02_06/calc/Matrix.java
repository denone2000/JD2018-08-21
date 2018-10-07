package by.it.nesterovich.jd02_06.calc;

import java.io.IOException;
import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] matrix) {
        value = Arrays.copyOf(matrix, matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            value[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
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

    public double[][] getValue() {
        return this.value;
    }

    @Override
    public Var add(Var other) throws CalcException, IOException {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < 1; j++) {
                    res[i][j] = res[i][j] + ((Vector) other).getValue()[i];
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            if (((Matrix) other).value.length != this.value.length) {
                Logger.getInstance().log(Res.INSTANCE.get(StrConst.MATRIX_ADD_MATRIX));
                throw new CalcException(Res.INSTANCE.get(StrConst.MATRIX_ADD_MATRIX));
            }
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException, IOException {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < 1; j++) {
                    res[i][j] = res[i][j] - ((Vector) other).getValue()[i];
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            if (((Matrix) other).value[0].length != this.value.length) {
                Logger.getInstance().log(Res.INSTANCE.get(StrConst.MATRIX_SUB_MATRIX));
                throw new CalcException(Res.INSTANCE.get(StrConst.MATRIX_SUB_MATRIX));
            }
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((Vector) other).getValue()[j];
                }
            }
            double[] result = new double[res.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    result[i] = result[i] + res[i][j];
                }
            }
            return new Vector(result);
        } else if (other instanceof Matrix) {
            if (((Matrix) other).value[0].length != this.value.length) {
                Logger.getInstance().log(Res.INSTANCE.get(StrConst.MATRIX_MUL_MATRIX));
                throw new CalcException(Res.INSTANCE.get(StrConst.MATRIX_MUL_MATRIX));
            }
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double[][] result = new double[res.length][res[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    double sum = 0;
                    for (int k = 0; k < res.length; k++) {
                        sum = sum + res[i][k] * ((Matrix) other).value[k][j];
                    }
                    result[i][j] = sum;
                }
            }
            return new Matrix(result);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiterI = "{";
        for (double[] aValue : value) {
            sb.append(delimiterI);
            String delimiterJ = "";
            for (double anAValue : aValue) {
                sb.append(delimiterJ).append(anAValue);
                delimiterJ = ", ";
            }
            delimiterI = "}, {";
        }
        sb.append("}}");
        return sb.toString();
    }
}
