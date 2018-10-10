package by.it.korzik.jd02.jd02_04;

import by.it.korzik.jd02.jd02_04.CalcException;
import by.it.korzik.jd02.jd02_04.Var;

class Scalar extends Var {
    private double value;


    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        value = otherScalar.value;
    }

    Scalar(String strValue) {
        value = Double.parseDouble(strValue);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);}
    else{
            return new Scalar(-1).mul(other).add(this);}}

    @Override
    public Var mul(Var other) throws CalcException {
            if (other instanceof Scalar) {
                double mul = this.value * ((Scalar) other).value;
                return new Scalar(mul);}
            else{
                return other.mul(this);}}

    @Override
    public Var div(Var other) throws CalcException {
                if (other instanceof Scalar) {
                    double otherScal = ((Scalar)other).value;
                    if (otherScal==0){
                        throw new CalcException("Деление на ноль");
                    }
                    double div = this.value / otherScal;
                    return new Scalar(div);}
                else{
                    return super.div(other);}}
}
