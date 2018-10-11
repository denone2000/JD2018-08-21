package by.it.yaroshchuk.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double value [][];

    Matrix (Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix (double[][] value){
        this.value = value;
    }

    Matrix (String str){
        int occurrencesCount = str.length() - str.replace("}","").length() - 1;
        Pattern pattern = Pattern.compile("([0-9]*[.])?[0-9]+");
        StringBuilder sb = new StringBuilder();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            sb.append(matcher.group());
            sb.append(" ");
        }
        String[] strValue =  sb.toString().split(" ");
        int colCount = strValue.length / occurrencesCount;
        value = new double[occurrencesCount][colCount];
        for (int i = 0, k = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++, k++) {
                value[i][j] = Double.parseDouble(strValue[k]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){

            double [][] result = new double [value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                result[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] += scalar;
                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Matrix){
            double [][] result = new double [value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                result[i] = Arrays.copyOf(value[i], value[i].length);
            }

            double [][] matrix = new double [((Matrix) other).value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = Arrays.copyOf(((Matrix) other).value[i], ((Matrix) other).value[i].length);
            }

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += matrix[i][j];
                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Vector){
            double [][] matrix = new double [value.length][value[0].length];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = Arrays.copyOf(value[i], value[i].length);
            }

            double [] vector = Arrays.copyOf(((Vector) other).getValue(), ((Vector) other).getValue().length);
            double [] result = new double[vector.length];
            for (int i = 0; i < vector.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    result[i] += vector[j] * matrix[i][j];
                }
            }
            return new Vector(result);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double [][] result = new double [value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                result[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] -= scalar;
                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Matrix){
            double [][] result = new double [value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                result[i] = Arrays.copyOf(value[i], value[i].length);
            }

            double [][] matrix = new double [((Matrix) other).value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = Arrays.copyOf(((Matrix) other).value[i], ((Matrix) other).value[i].length);
            }

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] -= matrix[i][j];
                }
            }
            return new Matrix(result);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double [][] result = new double [value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                result[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] *= scalar;
                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Matrix){
            double [][] matrixLeft = new double [value.length][value[0].length];
            for (int i = 0; i < matrixLeft.length; i++) {
                matrixLeft[i] = Arrays.copyOf(value[i], value[i].length);
            }

            double [][] matrixRight = new double [((Matrix) other).value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < matrixRight.length; i++) {
                matrixRight[i] = Arrays.copyOf(((Matrix) other).value[i], ((Matrix) other).value[i].length);
            }

            double[][] result = new double [matrixLeft.length][matrixRight[0].length];
            for (int i = 0; i < matrixLeft.length; i++) {
                for (int j = 0; j < matrixRight[0].length; j++) {
                    for (int k = 0; k < matrixLeft[0].length; k++) {
                        result[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                    }

                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Vector){
            double [][] matrix = new double [value.length][value[0].length];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = Arrays.copyOf(value[i], value[i].length);
            }

            double [] vector = Arrays.copyOf(((Vector) other).getValue(), ((Vector) other).getValue().length);
            double [] result = new double[vector.length];
            for (int i = 0; i < vector.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    result[i] += vector[j] * matrix[i][j];
                }
            }
            return new Vector(result);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter ="";
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                if(j + 1 < value[0].length)
                    sb.append(", ");
            }
            sb.append("}");
            if(i + 1 <  value.length)
                sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
