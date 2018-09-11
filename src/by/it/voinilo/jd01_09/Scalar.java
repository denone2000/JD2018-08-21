package by.it.voinilo.jd01_09;

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

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else
            return other.add(this);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double subs = this.value - ((Scalar) other).value;
            return new Scalar(subs);
        } else
            return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mult = this.value * ((Scalar) other).value;
            return new Scalar(mult);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double divs = this.value / ((Scalar) other).value;
            return new Scalar(divs);
        } else
            return other.div(this);
    }



    @Override
    public String toString() {
        return Double.toString(value);
    }
}
