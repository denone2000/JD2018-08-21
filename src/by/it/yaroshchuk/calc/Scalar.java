package by.it.yaroshchuk.calc;

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
    public Var add(Var other) throws CalcException {
         if(other instanceof Scalar)
             return new Scalar(this.value + ((Scalar) other).value);
         else
             return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar)
            return new Scalar(this.value - ((Scalar) other).value);
        else {
            Var minus = new Scalar(-1);
            return minus.mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar)
            return new Scalar(this.value * ((Scalar) other).value);
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar) {
            double buf = ((Scalar) other).value;
            if (buf == 0) throw new CalcException("деление на ноль");
            return new Scalar(this.value / buf);
        }
        else
            return super.div(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
