package by.it.akhmelev.jd01_08;

class Scalar extends Var {
    public double getValue() {
        return value;
    }

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar){
        value=otherScalar.value;
    }

    public Scalar(String strValue) {
        value=Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar=(Scalar) other;
            double result=this.value+otherScalar.value;
            return new Scalar(result);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double result=this.value-((Scalar) other).value;
            return new Scalar(result);
        }
        else {
            Var minus=new Scalar(-1);
            return minus.mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double result=this.value*((Scalar) other).value;
            return new Scalar(result);
        }
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double result=this.value/((Scalar) other).value;
            return new Scalar(result);
        }
        else
            return super.div(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
