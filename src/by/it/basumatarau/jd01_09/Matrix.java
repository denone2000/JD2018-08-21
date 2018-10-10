package by.it.basumatarau.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var{
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
    public Var addTo(Scalar scalar) {
        double[][] result = new double[value.length][value[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j]=value[i][j] + scalar.getVal();
            }
        }
        return new Matrix(result);
    }
    @Override
    public Var addTo(Vector vector) {
        return super.add(vector);
    }
    @Override
    public Var addTo(Matrix matrix) {
        if (value.length!=matrix.getValue().length&&value[0].length!=matrix.getValue()[0].length){
            return super.add(matrix);
        }
        double[][] result = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                result[i][j]= value[i][j] + matrix.getValue()[i][j];
            }
        }
        return new Matrix(result);
    }
    @Override
    public Var add(Var other) {
        return other.addTo(this);
    }

    @Override
    public Var subAnother(Matrix matrix) {
        if (value.length!=matrix.getValue().length&&value[0].length!=matrix.getValue()[0].length){
            return super.sub(matrix);
        }
        double[][] result = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                result[i][j]= matrix.getValue()[i][j] - value[i][j];
            }
        }
        return new Matrix(result);
    }
    @Override
    public Var subAnother(Scalar scalar) {
        return super.sub(scalar);
    }
    @Override
    public Var subAnother(Vector vector) {
        if(value.length>1) {
            return super.sub(vector);
        }else{
            double[] result = Arrays.copyOf(vector.getValue(), vector.getValue().length);
            for (int i = 0; i < result.length; i++) {
                result[i]-=this.value[0][i];
            }
            return new Vector(result);
        }
    }
    @Override
    public Var sub(Var other) {
        return other.subAnother(this);
    }

    @Override
    public Var mulBy(Scalar scalar) {
        double[][] result = new double[value.length][value[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = value[i][j]*scalar.getVal();
            }
        }
        return new Matrix(result);
    }
    @Override
    public Var mulBy(Vector vector) {
        if(this.value.length!=vector.getValue().length&&value[0].length!=1) {
            return super.mul(vector);
        }else{
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    result[i]+= vector.getValue()[j]*this.value[i][j];
                }
            }
            return new Vector(result);
        }
    }
    @Override
    public Var mulBy(Matrix matrix) {
        if(matrix.value[0].length!=value.length){
            return super.mul(matrix);
        }
        double[][] result = new double[matrix.getValue().length][value[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                for (int iterator = 0; iterator< result.length; iterator++){
                    result[i][j]+=matrix.getValue()[i][iterator]*value[iterator][j];
                }
            }
        }
        return new Matrix(result);
    }
    @Override
    public Var mul(Var other) {
        return other.mulBy(this);
    }

    @Override
    public Var divBy(Matrix matrix) {
        return super.div(matrix);
    }
    @Override
    public Var divBy(Scalar scalar) {
        return super.div(scalar);
    }
    @Override
    public Var divBy(Vector vector) {
        return super.div(vector);
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
