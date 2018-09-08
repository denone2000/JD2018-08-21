package by.it.korolchuk.jd01_08;


import java.util.Arrays;

public class Vector extends Var {
    public double[] getValue() {
        return value;
    }

    private double[] value;

    public Vector(double[] doubles) {
        value = Arrays.copyOf(doubles, doubles.length);
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

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] += scalar;
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).value[i];
            }
            return new Vector(result);
        } else

            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] -= scalar;
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
        } else

            return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] *= scalar;
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            double res = 0;
            for (int i = 0; i < result.length; i++) {
                res += result[i] *= ((Vector) other).value[i];
            }
            return new Scalar(res);
        } else

            return super.add(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] /= scalar;
            }
            return new Vector(result);
        } else
            return super.add(other);
    }


    /*public Vector(double[] value) {
        this.value = value;
    }*/

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        //{1,2,3,4,5}
        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String[] strArray = strVector.split(",\\s*");
        value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }
}

