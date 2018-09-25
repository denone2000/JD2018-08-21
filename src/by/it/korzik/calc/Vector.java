package by.it.korzik.calc;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        value = vector.value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Vector) {
            if (this.value.length!=((Vector)other).value.length){
                return super.add(other);
            }
            double[] sum = new double[this.value.length];
            if (this.value.length == ((Vector) other).value.length) {
                for (int i = 0; i < this.value.length; i++) {
                    sum[i] = this.value[i] + ((Vector) other).value[i];
                }
            }
            return new Vector(sum);
        }
        if (other instanceof Scalar) {
            double[] sum = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                sum[i] = this.value[i] + ((Scalar) other).getValue();
            }
            return new Vector(sum);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Vector) {
            if (this.value.length!=((Vector)other).value.length){
                return super.sub(other);
            }
            double[] sub = new double[this.value.length];
            if (this.value.length == ((Vector) other).value.length) {
                for (int i = 0; i < this.value.length; i++) {
                    sub[i] = this.value[i] - ((Vector) other).value[i];
                }
            }
            return new Vector(sub);
        }
        if (other instanceof Scalar) {
            double[] sub = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                sub[i] = this.value[i] - ((Scalar) other).getValue();
            }
            return new Vector(sub);
        }
        return super.sub(other);
    }


    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Vector) {
            double mul = 0;
            if (this.value.length == ((Vector) other).value.length) {
                for (int i = 0; i < this.value.length; i++) {
                    mul = mul + this.value[i] * ((Vector) other).value[i];
                }
            }
            return new Scalar(mul);
        }
        if (other instanceof Scalar) {
            double[] mul = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mul[i] = this.value[i] * ((Scalar) other).getValue();
            }
            return new Vector(mul);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        else {
            return super.div(other);}
    }

    Vector(String strVec) {
        strVec = strVec.replace('{', ' ').replace('}', ' ').trim();
        String[] strArr = strVec.split(",\\s*");
        value = new double[strArr.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strArr[i]);
        }


    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimit = "";
        for (double v : value) {
            sb.append(delimit).append(v);
            delimit = ", ";
        }
        sb.append("}");
        String result = sb.toString();
        return result;
    }
}
