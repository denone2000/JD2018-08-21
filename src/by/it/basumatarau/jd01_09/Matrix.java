package by.it.basumatarau.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value){
        this.value = new double[value.length][value[0].length];

        System.arraycopy(value, 0, this.value, 0, value.length);
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }
    public Matrix(Matrix anotherMatrix){
        this.value = new double[anotherMatrix.value.length][anotherMatrix.value[0].length];
        System.arraycopy(anotherMatrix.value, 0 , this.value, 0, anotherMatrix.value.length);
        for (int i = 0; i < anotherMatrix.value[0].length; i++) {
            System.arraycopy(anotherMatrix.value[i], 0, this.value[i], 0, anotherMatrix.value.length);
        }
    }
    public Matrix(String strMatrix){
        Pattern NumLine= Pattern.compile("(\\{[^{}]+\\})");
        Matcher NumLineMatcher = NumLine.matcher(strMatrix);
        int lines = 0;
        while(NumLineMatcher.find()) lines++;
        String[][] matrLines = new String[lines][];
        NumLineMatcher.reset(strMatrix);
        for (int i = 0; i < lines && NumLineMatcher.find(); i++) {
            matrLines[i] = NumLineMatcher.group().replace('{', ' ').replace('}', ' ').trim().split(",\\s*");
        }
        double[][] result = new double[matrLines.length][matrLines[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j]=Double.parseDouble(matrLines[i][j]);
            }
        }
        this.value = result;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Matrix){
            if (value.length!=((Matrix) other).getValue().length&&value[0].length!=((Matrix) other).getValue()[0].length){
                System.out.println("operation add is not allowed for matrices of different dimensions");
                return null;
            }
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j]= this.value[i][j] + ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(result);
        }else if (other instanceof Scalar){
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j]=value[i][j] + ((Scalar) other).getVal();
                }
            }
            return new Matrix(result);
        }else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix){
            if (value.length!=((Matrix) other).getValue().length&&value[0].length!=((Matrix) other).getValue()[0].length){
                System.out.println("operation sub is not allowed for matrices of different dimensions");
                return null;
            }
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j]= this.value[i][j] - ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(result);
        }else if (other instanceof Scalar){
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j]=value[i][j] - ((Scalar) other).getVal();
                }
            }
            return new Matrix(result);
        }else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Matrix){
            if(((Matrix) other).value[0].length!=this.value.length){
                System.out.println("operation add is mot allowed: amount of rows of left matrix is not equal to the amount of columns of the right matrix");
                return null;
            }
            double[][] result = new double[this.value.length][this.value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    for (int iterator = 0; iterator< result.length; iterator++){
                        result[i][j]+=this.value[i][iterator]*((Matrix) other).value[iterator][j];
                    }
                }
            }
            return new Matrix(result);
        }else if(other instanceof Vector){
            if(this.value.length!=((Vector) other).getValue().length){
                System.out.println("operation mul is not allowed for matrix and vector that have different amount of rows and columns respectively");
                return null;
            }
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    result[i]+= ((Vector) other).getValue()[j]*this.value[i][j];
                }
            }
            return new Vector(result);
        }else if(other instanceof Scalar){
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j]*((Scalar) other).getVal();
                }
            }
            return new Matrix(result);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String delimiterNum;
        String delimiterArr="";
        result.append("{");
        for (double[] row : value) {
            result.append(delimiterArr);
            delimiterNum = "";
            result.append("{");
            for (double num : row) {
                result.append(delimiterNum).append(Double.toString(num));
                delimiterNum = ", ";
            }
            result.append("}");
            delimiterArr = ", ";
        }
        result.append("}");
        return result.toString();
    }
}
