package by.it.bindyuk.jd02_06.calcV3;

import java.util.Arrays;

class Vector extends Var {
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
    public Var add(Var other) throws CalcException {
        if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] + ((Vector) other).value[i];
            }
            if (this.value.length != ((Vector) other).value.length) {
                ConsoleRunner.logger.log(ConsoleRunner.res.getKeys
                        (Messages.ERROR_LENGHT_VECTOR));
                throw new CalcException(ConsoleRunner.res.getKeys
                        (Messages.ERROR_LENGHT_VECTOR));
            }
            return VarSelector.getVar(res);//new Vector(res);

        } else if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] + ((Scalar) other).getValue();
            }
            return VarSelector.getVar(res);//new Vector(res);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] - ((Scalar) other).getValue();
            }
            return VarSelector.getVar(res);//new Vector(res);

        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] - ((Vector) other).value[i];
            }
            if (this.value.length != ((Vector) other).value.length) {
                ConsoleRunner.logger.log(ConsoleRunner.res.getKeys
                        (Messages.ERROR_LENGHT_VECTOR));
                throw new CalcException(ConsoleRunner.res.getKeys
                        (Messages.ERROR_LENGHT_VECTOR));
            }
            return VarSelector.getVar(res);//new Vector(res);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] * ((Scalar) other).getValue();
            }
            return VarSelector.getVar(res);//new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            double mul = 0;
            for (int i = 0; i < res.length; i++) {
                mul += this.value[i] * ((Vector) other).value[i];
            }
            return VarSelector.getVar(mul);//new Scalar(mul);
        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] / ((Scalar) other).getValue();
            }
            return VarSelector.getVar(res);//new Vector(res);
        } else
            return super.div(this);
    }
}
