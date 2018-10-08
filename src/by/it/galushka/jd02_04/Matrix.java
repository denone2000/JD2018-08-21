package by.it.galushka.jd02_04;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private static Res res = Res.INSTANCE;

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String[] rowsMatrix = strMatrix.split("\\}\\,\\s?\\{");
        int lengthRows = 0;
        int lengthColomns = rowsMatrix.length;
        for (String str : rowsMatrix) {
            StringBuilder sb = new StringBuilder(str);
            Pattern compile = Pattern.compile("[0-9]+(\\.[0-9]+)?");
            Matcher matcher = compile.matcher(str);
            while (matcher.find()) {
                lengthRows++;
            }
            break;
        }
        this.value = new double[lengthColomns][lengthRows];
        for (int i = 0; i < rowsMatrix.length; i++) {
            double[] colomnsMatrix = {};
            StringBuilder sb = new StringBuilder(rowsMatrix[i]);
            Pattern compile = Pattern.compile("\\-?[0-9]+(\\.[0-9]+)?");
            Matcher matcher = compile.matcher(sb);
            while (matcher.find()) {
                String group = matcher.group();
                double convertToDouble = Double.parseDouble(group);
                colomnsMatrix = Arrays.copyOf(colomnsMatrix, colomnsMatrix.length+1);
                colomnsMatrix[colomnsMatrix.length-1] = convertToDouble;
            }
            for (int j = 0; j < colomnsMatrix.length; j++) {
                this.value[i][j] = colomnsMatrix[j];
            }
        }
    }

    @Override
    public Var add(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double[][] resAdd = new double[value.length][value[0].length];
            for (int i = 0; i < resAdd.length; i++) {
                for (int j = 0; j < resAdd[0].length; j++) {
                    resAdd[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(resAdd);
        }
        if (other instanceof Matrix) {
            double[][] resAddMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < resAddMatrix.length; i++) {
                for (int j = 0; j < resAddMatrix[0].length; j++) {
                    resAddMatrix[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(resAddMatrix);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double[][] resSub = new double[value.length][value[0].length];
            for (int i = 0; i < resSub.length; i++) {
                for (int j = 0; j < resSub[0].length; j++) {
                    resSub[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(resSub);
        }
        if (other instanceof Matrix) {
            double[][] resSubMatrix = new double[value.length][value[0].length];
            int thisLength = this.value.length;
            int otherLength = ((Matrix) other).value[0].length;
            if (thisLength != otherLength)
                throw new CalcException(res.get(Messages.MSG_ERROR_SIZE_MATRIX));
            for (int i = 0; i < resSubMatrix.length; i++) {
                for (int j = 0; j < resSubMatrix[0].length; j++) {
                    resSubMatrix[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(resSubMatrix);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double[][] resMul = new double[value.length][value[0].length];
            for (int i = 0; i < resMul.length; i++) {
                for (int j = 0; j < resMul[0].length; j++) {
                    resMul[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(resMul);
        }
        if (other instanceof Matrix) {
            double[][] resMulMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < resMulMatrix.length; i++) {
                for (int j = 0; j < resMulMatrix[0].length; j++) {
                    for (int k = 0; k < resMulMatrix[0].length; k++) {
                        resMulMatrix[i][j] = resMulMatrix[i][j] + value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(resMulMatrix);
        }
        if (other instanceof Vector) {
            double[] resMul = new double[((Vector) other).getValue().length];
            for (int i = 0; i < resMul.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    resMul[i] = resMul[i] + ((Vector) other).getValue()[j] * value[i][j];
                }
            }
            return new Vector(resMul);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other)throws CalcException {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{{");
        String delimiter = ", ";
        for (int i = 0; i < this.value.length-1; i++) {
            for (int j = 0; j < this.value[0].length-1; j++) {
                sb.append(this.value[i][j] + delimiter);
            }
            sb.append(this.value[i][this.value[0].length-1]).append("}, {");
        }
        for (int j = 0; j < this.value[0].length-1; j++) {
            sb.append(this.value[this.value.length-1][j] + delimiter);
        }
        sb.append(this.value[this.value.length-1][this.value[0].length-1]).append("}}");
        return sb.toString();
    }
}
