package by.it.nesterovich.jd02_06.calc;

import java.io.IOException;
import java.util.Arrays;

class VarMatrix extends Var {

    private double[][] value;

    VarMatrix(double[][] matrix) {
        value = Arrays.copyOf(matrix, matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            value[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
    }

    VarMatrix(VarMatrix matrix) {
        this.value = matrix.value;
    }

    VarMatrix(String strMatrix) {
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
        if (other instanceof VarScalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((VarScalar) other).getValue();
                }
            }
            return new VarMatrix(res);
        } else if (other instanceof VarVector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < 1; j++) {
                    res[i][j] = res[i][j] + ((VarVector) other).getValue()[i];
                }
            }
            return new VarMatrix(res);
        } else if (other instanceof VarMatrix) {
            if (((VarMatrix) other).value.length != this.value.length) {
                Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.MATRIX_ADD_MATRIX), TitleType.ERROR);
                throw new CalcException(Res.INSTANCE.get(StrConst.MATRIX_ADD_MATRIX));
            }
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((VarMatrix) other).value[i][j];
                }
            }
            return new VarMatrix(res);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException, IOException {
        if (other instanceof VarScalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((VarScalar) other).getValue();
                }
            }
            return new VarMatrix(res);
        } else if (other instanceof VarVector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < 1; j++) {
                    res[i][j] = res[i][j] - ((VarVector) other).getValue()[i];
                }
            }
            return new VarMatrix(res);
        } else if (other instanceof VarMatrix) {
            if (((VarMatrix) other).value[0].length != this.value.length) {
                Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.MATRIX_SUB_MATRIX),TitleType.ERROR);
                throw new CalcException(Res.INSTANCE.get(StrConst.MATRIX_SUB_MATRIX));
            }
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((VarMatrix) other).value[i][j];
                }
            }
            return new VarMatrix(res);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof VarScalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((VarScalar) other).getValue();
                }
            }
            return new VarMatrix(res);
        } else if (other instanceof VarVector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((VarVector) other).getValue()[j];
                }
            }
            double[] result = new double[res.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    result[i] = result[i] + res[i][j];
                }
            }
            return new VarVector(result);
        } else if (other instanceof VarMatrix) {
            if (((VarMatrix) other).value[0].length != this.value.length) {
                Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.MATRIX_MUL_MATRIX),TitleType.ERROR);
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
                        sum = sum + res[i][k] * ((VarMatrix) other).value[k][j];
                    }
                    result[i][j] = sum;
                }
            }
            return new VarMatrix(result);
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
