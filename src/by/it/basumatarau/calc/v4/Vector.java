package by.it.basumatarau.calc.v4;

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
    public Var addTo(Vector vector) throws CalcException {
        if(this.value.length!=vector.value.length){
            return super.add(vector);
        }
        double[] result = Arrays.copyOf(vector.value, vector.value.length);
        for (int i = 0; i < result.length; i++) {
            result[i]+=this.value[i];
        }
        return new Vector(result);
    }
    @Override
    public Var addTo(Scalar scalar) {
        double[] result = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < result.length; i++) {
            result[i]+=scalar.getVal();
        }
        return new Vector(result);
    }
    @Override
    public Var addTo(Matrix matrix) throws CalcException {
        return matrix.addTo(this);
    }
    @Override
    public Var add(Var other)throws CalcException {
        return other.addTo(this);
    }

    @Override
    public Var subAnother(Matrix matrix)throws CalcException {
        if(matrix.getValue().length>1&&matrix.getValue()[0].length!=value.length){
            return super.mul(matrix);
        }
        double[] result = new double[value.length];
        for (int i = 0; i < result.length; i++) {
            result[i]=matrix.getValue()[0][i]-value[i];
        }
        return new Vector(result);
    }
    @Override
    public Var subAnother(Vector vector) throws CalcException{
        if(this.value.length!=vector.value.length){
            return super.sub(vector);
        }
        double[] result = Arrays.copyOf(vector.getValue(), vector.getValue().length);
        for (int i = 0; i < result.length; i++) {
            result[i]-= this.value[i];
        }
        return new Vector(result);
    }
    @Override
    public Var subAnother(Scalar scalar) {
        double[] result = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < result.length; i++) {
            result[i]-=scalar.getVal();
        }
        return new Vector(result);
    }
    @Override
    public Var sub(Var other)throws CalcException {
        return other.subAnother(this);
    }

    @Override
    public Var mulBy(Matrix matrix)throws CalcException {
        if(value.length!=matrix.getValue().length){
            return super.mul(matrix);
        }
        double[] result= new double[value.length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value.length; j++) {
                result[i]+= value[j]*matrix.getValue()[i][j];
            }
        }
        return new Vector(result);
    }

    @Override
    public Var mulBy(Vector vector) {
        double result = 0;
        for (int i = 0; i < this.value.length; i++) {
            result += this.value[i]*vector.value[i];
        }
        return new Scalar(result);
    }
    @Override
    public Var mulBy(Scalar scalar) {
        double[] result = Arrays.copyOf(this.getValue(), this.getValue().length);
        for (int i = 0; i < result.length; i++) {
            result[i]*=scalar.getVal();
        }
        return new Vector(result);
    }
    @Override
    public Var mul(Var other)throws CalcException {
        return other.mulBy(this);
    }

    @Override
    public Var divBy(Matrix matrix)throws CalcException {
        return super.div(matrix);
    }
    @Override
    public Var divBy(Vector vector)throws CalcException {
        return super.div(vector);
    }
    @Override
    public Var divBy(Scalar scalar)throws CalcException {
        return super.div(scalar);
    }
    @Override
    public Var div(Var other)throws CalcException {
        return other.divBy(this);
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
