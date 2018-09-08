package by.it.galushka.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value = {};

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        Pattern compile = Pattern.compile("[0-9]+");
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()) {
            String group = matcher.group();
            double convertToDouble = Double.parseDouble(group);
            this.value = Arrays.copyOf(this.value, this.value.length+1);
            this.value[this.value.length-1] = convertToDouble;
        }
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] resAdd = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < resAdd.length; i++) {
                resAdd[i] = resAdd[i] + ((Scalar) other).getValue();
            }
            return new Vector(resAdd);
        }
        if (other instanceof Vector) {
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                result[i] = result[i] + ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] resSub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resSub.length; i++) {
                resSub[i] = resSub[i] - ((Scalar) other).getValue();
            }
            return new Vector(resSub);
        }
        if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] resMul = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < resMul.length; i++) {
                resMul[i] = resMul[i] * ((Scalar) other).getValue();
            }
            return new Vector(resMul);
        }
        if (other instanceof Vector) {
            double[] otherVector = Arrays.copyOf(value, value.length);
            double mul = 0;
            for (int i = 0; i < value.length; i++) {
                mul = mul + value[i] * ((Vector) other).value[i];
            }
            return new Scalar(mul);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] resDiv = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resDiv.length; i++) {
                resDiv[i] = resDiv[i] / ((Scalar) other).getValue();
            }
            return new Vector(resDiv);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length-1; i++) {
            String delimiter = ", ";
            sb.append(value[i] + delimiter);
        }
        sb.append(value[value.length-1]).append("}");
        return sb.toString();
    }
}
