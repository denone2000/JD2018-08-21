package by.it.basumatarau.jd01_09;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;
    public double[] getValue(){
        return this.value;
    }
    public Vector(String strVector){
        strVector=strVector.replace("{","").replace("}","");
        String[] strArray = strVector.split("(,\\s*)");
        value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }
    public Vector(double[] value){
        this.value = Arrays.copyOf(value, value.length);
    }
    public Vector(Vector anotherVect){
        this.value = Arrays.copyOf(anotherVect.value, anotherVect.value.length);
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Vector){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i]+=((Vector) other).value[i];
            }
            return new Vector(result);
        } else if(other instanceof Scalar){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i]+=((Scalar)other).getVal();
            }
            return new Vector(result);
        } else {
            return super.add(this);
        }
    }
    @Override
    public Var sub(Var other) {
        if (other instanceof Vector){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i]-= ((Vector) other).value[i];
            }
            return new Vector(result);
        } else if(other instanceof Scalar){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i]-=((Scalar) other).getVal();
            }
            return new Vector(result);
        } else{
            return super.sub(this);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i]=this.value[i]*((Scalar) other).getVal();
            }
            return new Vector(result);
        }else if(other instanceof Vector){
            if(((Vector)other).value.length!=value.length){
                System.out.println("operation mul is not allowed for Vectors of different length");
                return null;
            } else {
                double result = 0;
                for (int i = 0; i < this.value.length; i++) {
                    result += this.value[i]*((Vector) other).value[i];
                }
                return new Scalar(result);
            }
        }else if(other instanceof Matrix){
            if(((Matrix) other).getValue()[0].length!=1){
                System.out.println("operation mul is not allowed for matrix and vector that have different amount of columns and rows (vector has only one row) respectively");
                return null;
            }
            double[][] result = new double[this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    result[i][j]+=this.value[j]*((Matrix) other).getValue()[i][0];
                }
            }
            return new Matrix(result);
        }
        else{
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                result[i]= this.value[i]/((Scalar)other).getVal();
            }
            return new Vector(result);
        } else {
           return super.div(other);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";
        for (double currentVal : value) {
            result.append(delimiter).append(currentVal);
            delimiter=", ";
        }
        result.append("}");
        return result.toString();
    }
}
