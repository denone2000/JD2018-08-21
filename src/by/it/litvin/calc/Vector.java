package by.it.litvin.calc;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(String strVector) {

        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String[] strArray = strVector.split(",\\s*");
        value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);


        }
    }

    Vector(double[] value) {
        this.value = value;


    }

    Vector(Vector varScalar) {
        this(varScalar.value);
    }

    @Override
    public Var add(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < res.length; i++) {
                res[i] += scalar;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if(this.value.length!=((Vector)other).value.length)
                throw new CalcException("Размеры не совпадают");

            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < res.length; i++) {
                res[i] -= scalar;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if(this.value.length!=((Vector)other).value.length)
            throw new CalcException("Размеры не совпадают");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public Var mul(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < res.length; i++) {
                res[i] =res[i]* scalar;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if(this.value.length!=((Vector)other).value.length)
            throw new CalcException("Размеры не совпадают");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]*((Vector) other).value[i];
            }
            double result=0;
            for (double element:res) {
                result+=element;
                
            }
            return new Scalar(result);
        } else
            return super.add(other);
    }

    @Override
    public Var div(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < res.length; i++) {
                res[i] =res[i]/ scalar;
            }
            return new Vector(res);

        } else
            return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";
        for (double currentValue : value) {
            result.append(delimiter).append(currentValue);
            delimiter = ", ";


        }
        result.append("}");
        return result.toString();
    }
}
