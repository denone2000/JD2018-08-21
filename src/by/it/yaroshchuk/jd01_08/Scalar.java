package by.it.yaroshchuk.jd01_08;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
         this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar) {
         this.value = scalar.value;
    }

    @Override
    public Var add(Var other) {
         if(other instanceof  Scalar)
             return new Scalar(this.value + ((Scalar) other).value);
         else
             return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof  Scalar)
            return new Scalar(this.value - ((Scalar) other).value);
        else {
            Var minus = new Scalar(-1);
            return minus.mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof  Scalar)
            return new Scalar(this.value * ((Scalar) other).value);
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof  Scalar)
            return new Scalar(this.value / ((Scalar) other).value);
        else
            return super.div(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
