package by.it.basumatarau.jd01_09;
import java.util.Arrays;

public class Scalar extends Var {
    private double value;

    public double getVal(){
        return this.value;
    }

    @Override
    public Var add(Var other) {
        return other.addTo(this);
    }
    @Override
    public Var addTo(Vector vector) {
        return vector.addTo(this);
    }
    @Override
    public Var addTo(Scalar scalar) {
        return new Scalar(this.getVal()+ scalar.getVal());
    }
    @Override
    public Var addTo(Matrix matrix) {
        return matrix.addTo(this);
    }

    @Override
    public Var subAnother(Matrix matrix) {
        return this.mul(new Scalar(-1)).addTo(matrix);
    }
    @Override
    public Var subAnother(Vector vector) {
        return vector.subAnother(this);
    }
    @Override
    public Var subAnother(Scalar scalar) {
        return new Scalar(scalar.getVal() - this.getVal());
    }
    @Override
    public Var sub(Var other) {
        return other.subAnother(this);
    }

    @Override
    public Var mul(Var other) {
        return other.mulBy(this);
    }
    @Override
    public Var mulBy(Scalar scalar) {
        return new Scalar(scalar.getVal()*this.getVal());
    }
    @Override
    public Var mulBy(Vector vector) {
        double[] result = Arrays.copyOf(vector.getValue(), vector.getValue().length);
        for (int i = 0; i < result.length; i++) {
            result[i]*=this.getVal();
        }
        return new Vector(result);
    }
    @Override
    public Var mulBy(Matrix matrix) {
        return matrix.mulBy(this);
    }

    @Override
    public Var divBy(Matrix matrix) {
        double[][] result = new double[matrix.getValue().length][matrix.getValue()[0].length];
        for (int i = 0; i < matrix.getValue().length; i++) {
            for (int j = 0; j < matrix.getValue()[0].length; j++) {
                result[i][j]= matrix.getValue()[i][j]/this.getVal();
            }
        }
        return new Matrix(result);
    }
    @Override
    public Var divBy(Scalar scalar) {
        return new Scalar(scalar.getVal()/this.getVal());
    }
    @Override
    public Var divBy(Vector vector) {
        double[] result = Arrays.copyOf(vector.getValue(), vector.getValue().length);
        for (int i = 0; i < vector.getValue().length; i++) {
            result[i]= vector.getValue()[i]/this.getVal();
        }
        return new Vector(result);
    }
    @Override
    public Var div(Var other) {
        return other.divBy(this);
    }

    public Scalar(double value){
        this.value = value;
    }
    public Scalar(Scalar scalarObj){
        value = scalarObj.value;
    }
    public Scalar(String strVal){
        value = Double.parseDouble(strVal);
    }
    @Override
    public String toString() {
        return Double.toString(this.value);
    }

}
