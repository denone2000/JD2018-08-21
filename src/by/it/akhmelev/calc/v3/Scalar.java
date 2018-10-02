package by.it.akhmelev.calc.v3;

import by.it.akhmelev.calc.v3.*;

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
    public Var add(Var other) throws by.it.akhmelev.calc.v3.CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar=(Scalar) other;
            double result=this.value+otherScalar.value;
            return new Scalar(result);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws by.it.akhmelev.calc.v3.CalcException {
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
    public Var mul(Var other) throws by.it.akhmelev.calc.v3.CalcException {
        if (other instanceof Scalar) {
            double result=this.value*((Scalar) other).value;
            return new Scalar(result);
        }
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws by.it.akhmelev.calc.v3.CalcException {
        if (other instanceof Scalar) {
            double zzz = ((Scalar) other).value;
            if (zzz==0) throw new by.it.akhmelev.calc.v3.CalcException("Деление на ноль");
            double result=this.value/zzz;
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
