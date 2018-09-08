package by.it.bindyuk.jd01_08;

import java.util.Arrays;

public class Vector extends Var {
    public double[] getValue() {
        return value;
    }

    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        value = vector.value;
    }

    public Vector(String strVector) {
        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String[] strArray = strVector.split(",\\s*");
        value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimeter = "";
        for (double currentValue : value) {
            result.append(delimeter).append(currentValue);
            delimeter = ", ";
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] + ((Vector) other).value[i];
            }
            return new Vector(res);

        } else if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);

        } else if(other instanceof Vector){
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            double mul = 0;
            for (int i = 0; i < res.length; i++) {
                mul += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(mul);
        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else
        return super.div(this);
    }
}
