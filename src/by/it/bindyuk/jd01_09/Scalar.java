package by.it.bindyuk.jd01_09;

class Scalar extends Var {
    public double getValue() {
        return value;
    }

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        value = otherScalar.value;
    }

    Scalar(String strScalar) {
        value = Double.parseDouble(strScalar);
    }

    @Override

    public Var add(Var other) {
        if (other instanceof Scalar) {
            double add = this.value + ((Scalar) other).value;
            return new Scalar(add);
        } else return other.add(this);
    }

    @Override

    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else {
            Var minus = new Scalar(-1);
            return minus.mul(other).add(this);
        }
    }

    @Override

    public Var mul(Var other){
        if (other instanceof Scalar){
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else

            return super.div(other);
    }

    @Override

    public String toString() {
        return Double.toString(value);
    }
}




























