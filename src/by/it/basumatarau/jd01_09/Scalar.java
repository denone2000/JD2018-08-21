package by.it.basumatarau.jd01_09;

public class Scalar extends Var {
    private double value;
    public double getVal(){
        return this.value;
    }
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            return new Scalar(this.value + ((Scalar) other).value);
        }else{
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            return new Scalar(this.value - ((Scalar) other).value);
        }else{
            Scalar negScalar = new Scalar(-1);
            return negScalar.mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            return new Scalar(this.value*((Scalar) other).value);
        }else{
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            return new Scalar(this.value/((Scalar) other).value);
        }else {
            return other.mul(this);
        }
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
